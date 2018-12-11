package com.example.sellermodule.seller;

import com.example.sellermodule.rest.model.Seller;

public interface SellerView {
    void getSellerByID(String id);
    void setSeller(Seller seller);
}
