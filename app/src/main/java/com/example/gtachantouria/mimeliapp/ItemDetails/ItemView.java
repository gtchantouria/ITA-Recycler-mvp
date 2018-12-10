package com.example.gtachantouria.mimeliapp.ItemDetails;

import com.example.gtachantouria.mimeliapp.rest.model.Item;

public interface ItemView {
    void getItemByID(String id);
    void setItem(Item item);
}
