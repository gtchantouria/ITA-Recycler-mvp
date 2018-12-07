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
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import org.w3c.dom.Text;

import java.util.List;

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
        vh.mTextView.setText(list.items.get(i).title);
        Uri uri = Uri.parse(list.items.get(i).image);
        vh.mDraweeView.setImageURI(uri);
    }

    @Override
    public int getItemCount() {
        return list  == null ? 0 : list.items.size();
    }


    public class productHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        SimpleDraweeView mDraweeView;

        public productHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.tv_product);
            mDraweeView = (SimpleDraweeView) itemView.findViewById(R.id.my_image_view);
        }
    }
}
