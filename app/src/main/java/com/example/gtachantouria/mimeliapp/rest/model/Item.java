package com.example.gtachantouria.mimeliapp.rest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Item {

    @SerializedName("id")
    @Expose
    public String id;

    @SerializedName("title")
    @Expose
    public String title;

    @SerializedName("price")
    @Expose
    public Double price;

    @SerializedName("thumbnail")
    @Expose
    public String image;
}