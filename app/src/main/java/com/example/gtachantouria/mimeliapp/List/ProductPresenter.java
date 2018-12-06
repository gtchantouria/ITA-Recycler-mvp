package com.example.gtachantouria.mimeliapp.List;

import java.util.List;

public class ProductPresenter {

    private ProductView mProductView;
    private ProductHelper helper;

    public ProductPresenter(ProductView view){
        this.mProductView = view;
        helper =  new ProductHelper();
    }

    public List<Product> getProductList() {
        return helper.getList();
    }
}
