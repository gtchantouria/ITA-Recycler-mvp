package com.example.gtachantouria.mimeliapp.ItemDetails;

import android.util.Log;

import com.example.gtachantouria.mimeliapp.rest.model.Item;
import com.example.gtachantouria.mimeliapp.rest.service.MeliService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemPresenter {
    private ItemView mItemView;

    public ItemPresenter(ItemView view) {
        this.mItemView = view;
    }

    public void getItemByID(String id) {
        if(mItemView != null) {
            MeliService.getInstance().getItemByID(id, new Callback<Item>() {
                @Override
                public void onResponse(Call<Item> call, Response<Item> response) {
                    if(response.isSuccessful()){
                        mItemView.setItem(response.body());
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
}

