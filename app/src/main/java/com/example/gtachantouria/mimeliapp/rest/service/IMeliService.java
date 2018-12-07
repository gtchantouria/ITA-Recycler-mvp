package com.example.gtachantouria.mimeliapp.rest.service;

import com.example.gtachantouria.mimeliapp.rest.model.ItemList;
import com.example.gtachantouria.mimeliapp.rest.model.Item;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by guill on 6/23/2017.
 */
public interface IMeliService {

    @GET("sites/MLA/search")
    Call<ItemList> getItemsByQuery(@Query("q") String query);

    @GET("items/{id}")
    Call<Item> getItemById(@Path("id") String id);
}