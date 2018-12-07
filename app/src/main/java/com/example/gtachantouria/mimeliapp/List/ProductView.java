package com.example.gtachantouria.mimeliapp.List;

import java.util.List;

public interface ProductView {
    void showProgress();
    void hideProgress();
    void setItems(List<Product> items);
}

