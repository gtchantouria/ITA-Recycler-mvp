package com.example.gtachantouria.mimeliapp.List;

import com.example.gtachantouria.mimeliapp.rest.model.ItemList;

import java.util.List;

public interface ProductView {
    void showProgress();
    void hideProgress();
    //void setItems(List<Product> items);
    void setItems(ItemList items);
}

