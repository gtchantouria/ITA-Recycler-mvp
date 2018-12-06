package com.example.gtachantouria.mimeliapp.List;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.gtachantouria.mimeliapp.R;

import java.util.List;

public class ProductListActivity extends AppCompatActivity implements ProductView {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ProductPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        mPresenter = new ProductPresenter(this);
        setRecycler();
    }

    private void setRecycler(){
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_list);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new ProductAdapter(mPresenter.getProductList());
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public List<Product> showProducts() {
        Log.d("LOG", "test");
       return mPresenter.getProductList();
    }
}
