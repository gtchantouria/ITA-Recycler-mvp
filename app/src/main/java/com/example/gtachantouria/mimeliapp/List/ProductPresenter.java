package com.example.gtachantouria.mimeliapp.List;

import java.util.List;

public class ProductPresenter {

    private ProductView mProductView;
    private ProductHelper helper;

    public ProductPresenter(ProductView view, ProductHelper helper){
        this.mProductView = view;
        this.helper = helper;
    }

    void onResume() {
        if (mProductView != null) {
            mProductView.showProgress();
        }

        helper.findItems(this::onSuccess);
    }

    public void onSuccess(List<Product> list) {
        if(mProductView != null) {
            mProductView.setItems(list);
            mProductView.hideProgress();
        }
    }

    void onDestroy() {
        mProductView = null;
    }
}
