package com.example.gtachantouria.mimeliapp.List;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.example.gtachantouria.mimeliapp.R;
import com.example.gtachantouria.mimeliapp.rest.model.ItemList;

public class ProductListActivity extends AppCompatActivity implements ProductView {

    private RecyclerView mRecyclerView;
    private ProductPresenter mPresenter;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        mRecyclerView = findViewById(R.id.rv_list);
        mProgressBar = findViewById(R.id.pb_bar);
        mPresenter = new ProductPresenter(this);
    }


    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onResume();
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
        mRecyclerView.setAdapter(new ProductAdapter(items));
    }
}
