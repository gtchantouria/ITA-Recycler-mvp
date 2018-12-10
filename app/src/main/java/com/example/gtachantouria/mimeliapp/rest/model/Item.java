package com.example.gtachantouria.mimeliapp.rest.model;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Item {
    @SerializedName("id")
    public String id;

    @SerializedName("title")
    public String title;

    @SerializedName("price")
    public Double price;

    @SerializedName("thumbnail")
    public String image;

    @SerializedName("pictures")
    public List<Images> pictures;

    @SerializedName("permalink")
    public String linkToMeli;
}