package com.example.gtachantouria.mimeliapp.ItemsList;

import android.text.TextUtils;
import android.util.Log;

import com.example.gtachantouria.mimeliapp.rest.model.Item;
import com.example.gtachantouria.mimeliapp.rest.model.ItemList;
import com.example.gtachantouria.mimeliapp.rest.service.MeliService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductPresenter implements RecyclerItemClickListener {

    private ProductView mProductView;

    public ProductPresenter(ProductView view){
        this.mProductView = view;
    }

    public void getItemsByQuery(String query) {
        if(mProductView != null) {
            mProductView.showProgress();
            String toSearch = TextUtils.isEmpty(query) ? "ipod" : query;

            MeliService.getInstance().getItemsByQuery(toSearch, new Callback<ItemList>() {
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

    @Override
    public void onItemClickListener(String id) {
        mProductView.setItemSelected(id);
    }
}
