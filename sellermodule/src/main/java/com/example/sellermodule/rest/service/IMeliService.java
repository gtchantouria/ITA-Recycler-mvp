package com.example.sellermodule.rest.service;

import com.example.sellermodule.rest.model.Seller;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by guill on 6/23/2017.
 */
public interface IMeliService {

    @GET("users/{id}")
    Call<Seller> getSellerById(@Path("id") String id);
}