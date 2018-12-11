package com.example.sellermodule.seller;

import android.util.Log;

import com.example.sellermodule.rest.model.Seller;
import com.example.sellermodule.rest.service.MeliService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SellerPresenter {
    private SellerView mView;

    public SellerPresenter(SellerView view) {
        this.mView = view;
    }

    public void getSellerByID(String id) {
        if(mView != null) {
            MeliService.getInstance().getSellerByID(id, new Callback<Seller>() {
                @Override
                public void onResponse(Call<Seller> call, Response<Seller> response) {
                    if(response.isSuccessful()){
                        mView.setSeller(response.body());
                    }
                }

                @Override
                public void onFailure(Call<Seller> call, Throwable t) {
                    t.printStackTrace();
                    Throwable cause = t.getCause();
                    if(cause != null){
                        Log.d("Error getSellerByID", cause.getMessage());
                    }
                    else {
                        Log.d("Error no manejado", t.getMessage());
                    }
                }
            });
        }
    }
}
