package com.example.gtachantouria.mimeliapp.ItemsList;
import com.example.gtachantouria.mimeliapp.rest.model.ItemList;

public interface ProductView {
    void showProgress();
    void hideProgress();
    void setItems(ItemList items);
    void setItemSelected(String id);
}

