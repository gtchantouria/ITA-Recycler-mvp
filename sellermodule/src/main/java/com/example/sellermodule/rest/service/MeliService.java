package com.example.sellermodule.rest.service;

import com.example.sellermodule.rest.model.Seller;

import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MeliService {

    private static final String BASE_URL = "https://api.mercadolibre.com/";
    private static MeliService instance;
    private static IMeliService iMeliService;

    private MeliService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        iMeliService = retrofit.create(IMeliService.class);
    }

    public static MeliService getInstance(){
        if(instance == null){
            instance = new MeliService();
        }

        return  instance;
    }

    public void getSellerByID(String id, Callback<Seller> callback) {
        iMeliService.getSellerById(id).enqueue(callback);
    }
}
