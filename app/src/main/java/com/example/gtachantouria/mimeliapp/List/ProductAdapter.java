package com.example.gtachantouria.mimeliapp.List;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gtachantouria.mimeliapp.R;

import org.w3c.dom.Text;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.productHolder> {
    private List<Product> list;

    public ProductAdapter(List<Product> data) {
        list = data;
    }

    @NonNull
    @Override
    public productHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = (TextView) LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.product_row, viewGroup, false);

        productHolder vHolder = new productHolder(v);

        return new productHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull productHolder vh, int i) {
        vh.mTextView.setText(list.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return list  == null ? 0 : list.size();
    }


    public class productHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public productHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.tv_product);
        }
    }
}
