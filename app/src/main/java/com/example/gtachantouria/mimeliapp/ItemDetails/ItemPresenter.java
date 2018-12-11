package com.example.gtachantouria.mimeliapp.ItemDetails;

import android.util.Log;

import com.example.gtachantouria.mimeliapp.rest.model.Item;
import com.example.gtachantouria.mimeliapp.rest.service.MeliService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemPresenter {
    private ItemView mView;

    public ItemPresenter(ItemView view) {
        this.mView = view;
    }

    public void getItemByID(String id) {
        if(mView != null) {
            MeliService.getInstance().getItemByID(id, new Callback<Item>() {
                @Override
                public void onResponse(Call<Item> call, Response<Item> response) {
                    if(response.isSuccessful()){
                        mView.setItem(response.body());
                    }
                }

                @Override
                public void onFailure(Call<Item> call, Throwable t) {
                    t.printStackTrace();
                    Throwable cause = t.getCause();
                    if(cause != null){
                        Log.d("Error getItemsByQuery", cause.getMessage());
                    }
                    else {
                        Log.d("Error no manejado", t.getMessage());
                    }
                }
            });
        }
    }

    public void navigateToSeller(String sellerID) {
        if(mView != null) {
            mView.navigateToSeller("ml://vervendedor/" + sellerID);
        }
    }
}

