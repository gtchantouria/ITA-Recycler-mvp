package com.example.sellermodule.seller;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.sellermodule.R;
import com.example.sellermodule.rest.model.Seller;

public class SellerActivity extends AppCompatActivity implements SellerView {
    private final String LOG_ID = SellerActivity.class.getName();
    private TextView mSellerName;

    private SellerPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller);

        Intent intent = this.getIntent();

        if(intent != null) {
            Uri uri = intent.getData();
            String seller = uri.getPath().substring(1);
            mPresenter = new SellerPresenter(this);
            getSellerByID(seller);
        }
        else {
            Log.d(LOG_ID, "No item id selected.");
        }
    }

    @Override
    public void getSellerByID(String id) {
        mPresenter.getSellerByID(id);
    }

    @Override
    public void setSeller(Seller seller) {
        mSellerName = findViewById(R.id.tv_sellerName);
        mSellerName.setText(seller.id + " - " + seller.nickname);
    }
}
