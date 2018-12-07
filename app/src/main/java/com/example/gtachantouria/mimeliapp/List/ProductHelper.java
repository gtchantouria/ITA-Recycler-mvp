package com.example.gtachantouria.mimeliapp.List;

import android.os.Handler;

import java.util.ArrayList;
import java.util.List;

public class ProductHelper {

    interface OnFinishedListener {
        void onFinished(List<Product> items);
    }


    public void findItems(final OnFinishedListener listener) {
        new Handler().postDelayed(() -> listener.onFinished(this.getList()), 2000);
    }

    private List<Product> getList() {
        List<Product> list = new ArrayList<>();
        list.add(new Product("Product 1"));
        list.add(new Product("Product 2"));
        list.add(new Product("Product 3"));
        list.add(new Product("Product 4"));
        list.add(new Product("Product 5"));
        list.add(new Product("Product 6"));
        list.add(new Product("Product 7"));
        list.add(new Product("Product 8"));
        list.add(new Product("Product 9"));
        list.add(new Product("Product 10"));
        return list;
    }
}
