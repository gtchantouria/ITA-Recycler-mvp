package com.example.gtachantouria.mimeliapp.ItemsList;

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
    private ItemList mList;
    private RecyclerItemClickListener mListener;

    public ProductAdapter(ItemList data, RecyclerItemClickListener listener) {
        this.mList = data;
        this.mListener = listener;
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
        vh.mTitle.setText(mList.items.get(i).title);
        vh.mPrice.setText(String.format(NumberFormat.getCurrencyInstance().format(mList.items.get(i).price)));

        Uri uri = Uri.parse(mList.items.get(i).image);
        vh.mImage.setImageURI(uri);
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.items.size();
    }


    public class productHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView mTitle;
        public TextView mPrice;
        public SimpleDraweeView mImage;

        public productHolder(@NonNull View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.tv_product);
            mImage = itemView.findViewById(R.id.image);
            mPrice = itemView.findViewById(R.id.tv_price);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            mListener.onItemClickListener(mList.items.get(position).id);
        }
    }
}
