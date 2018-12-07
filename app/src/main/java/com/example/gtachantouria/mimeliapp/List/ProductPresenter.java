package com.example.gtachantouria.mimeliapp.List;

import android.util.Log;

import com.example.gtachantouria.mimeliapp.rest.model.ItemList;
import com.example.gtachantouria.mimeliapp.rest.service.MeliService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductPresenter {

    private ProductView mProductView;

    public ProductPresenter(ProductView view){
        this.mProductView = view;
    }

    void onResume() {
        if (mProductView != null) {
            mProductView.showProgress();
        }

        this.onSuccess();
    }

    public void onSuccess() {
        if(mProductView != null) {

            MeliService.getInstance().getItemsByQuery("ipod", new Callback<ItemList>() {
                @Override
                public void onResponse(Call<ItemList> call, Response<ItemList> response) {
                    if(response.isSuccessful()){
                        ItemList itemList = response.body();
                        mProductView.setItems(itemList);
                    }
                }

                @Override
                public void onFailure(Call<ItemList> call, Throwable t) {
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

            mProductView.hideProgress();
        }
    }

    void onDestroy() {
        mProductView = null;
    }
}
