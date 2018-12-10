package com.example.gtachantouria.mimeliapp.ItemDetails;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gtachantouria.mimeliapp.R;
import com.example.gtachantouria.mimeliapp.rest.model.Images;
import com.example.gtachantouria.mimeliapp.rest.model.Item;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.squareup.picasso.Picasso;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.List;

public class ItemActivity extends AppCompatActivity implements ItemView {
    private final String LOG_ID = ItemActivity.class.getName();
    private ItemPresenter mPresenter;

    private List<Images> mPictures;
    private CarouselView mCarousel;
    private TextView mDescription, mPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_details);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle != null) {
            mPresenter = new ItemPresenter(this);
            String id = bundle.getString("ItemID");
            getItemByID(id);
        }
        else {
            Log.d(LOG_ID, "No item id selected.");
        }
    }

    @Override
    public void getItemByID(String id) {
        mPresenter.getItemByID(id);
    }

    @Override
    public void setItem(Item item) {
        setItemDetails(item);
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            Picasso.get()
                    .load(mPictures.get(position).secureUrl)
                    .placeholder(android.R.drawable.ic_menu_info_details)
                    .into(imageView);
        }
    };

    private void setItemDetails(Item item) {
        // TODO show item details...
        mPictures = item.pictures;
        mCarousel = findViewById(R.id.carouselView);
        mCarousel.setImageListener(imageListener);
        mCarousel.setPageCount(mPictures.size());

        mDescription = findViewById(R.id.tv_description);
        mPrice = findViewById(R.id.tv_price);

        mDescription.setText(item.title);
        mPrice.setText(String.format("$ %s", Double.toString(item.price)));
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
        }
    }
}
