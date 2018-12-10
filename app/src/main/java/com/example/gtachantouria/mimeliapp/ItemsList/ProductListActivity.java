package com.example.gtachantouria.mimeliapp.ItemsList;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.gtachantouria.mimeliapp.ItemDetails.ItemActivity;
import com.example.gtachantouria.mimeliapp.R;
import com.example.gtachantouria.mimeliapp.rest.model.ItemList;

public class ProductListActivity extends AppCompatActivity implements ProductView {

    private final String SP = "mySharedPref";
    private RecyclerView mRecyclerView;
    private ProductPresenter mPresenter;
    private ProgressBar mProgressBar;
    private SearchView mSearchView;

    private SharedPreferences mPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        setViews();
    }

    private void setViews() {
        mRecyclerView = findViewById(R.id.rv_list);
        mProgressBar = findViewById(R.id.pb_bar);
        mPresenter = new ProductPresenter(this);
        mSearchView = findViewById(R.id.sv_search);

        SharedPreferences sp = getSharedPreferences(SP, MODE_PRIVATE);
        String test = sp.getString("QueryToSearch", "");
        if(!TextUtils.isEmpty(test)) {
            mSearchView.setQuery(test, true);
        } else {
            mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    SharedPreferences sharedPref =  getSharedPreferences(SP, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString("QueryToSearch", query);

                    mPresenter.getItemsByQuery(query);
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    return false;
                }
            });
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }

    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
        mRecyclerView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(View.INVISIBLE);
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void setItems(ItemList items) {
        mRecyclerView.setAdapter(new ProductAdapter(items, mPresenter));
    }

    @Override
    public void setItemSelected(String id) {
        //TODO Starts new activity sending Item id as parameter...
        Bundle bundle = new Bundle();
        bundle.putString("ItemID", id);

        Intent intent = new Intent();
        intent.putExtras(bundle);
        intent.setClass(this, ItemActivity.class);

        startActivity(intent);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
        }
    }
}
