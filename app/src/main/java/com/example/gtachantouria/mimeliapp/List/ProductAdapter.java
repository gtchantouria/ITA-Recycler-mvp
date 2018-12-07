package com.example.gtachantouria.mimeliapp.List;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gtachantouria.mimeliapp.R;
import com.example.gtachantouria.mimeliapp.rest.model.ItemList;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.NumberFormat;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.productHolder> {
    private ItemList list;

    public ProductAdapter(ItemList data) {
        list = data;
    }

    @NonNull
    @Override
    public productHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.product_row, viewGroup, false);

        productHolder vHolder = new productHolder(v);

        return new productHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull productHolder vh, int i) {
        vh.mTitle.setText(list.items.get(i).title);
        vh.mPrice.setText(String.format(NumberFormat.getCurrencyInstance().format(list.items.get(i).price)));

        Uri uri = Uri.parse(list.items.get(i).image);
        vh.mImage.setImageURI(uri);
    }

    @Override
    public int getItemCount() {
        return list  == null ? 0 : list.items.size();
    }


    public class productHolder extends RecyclerView.ViewHolder {
        public TextView mTitle;
        public TextView mPrice;
        public SimpleDraweeView mImage;

        public productHolder(@NonNull View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.tv_product);
            mImage = itemView.findViewById(R.id.image);
            mPrice = itemView.findViewById(R.id.tv_price);
        }
    }
}
