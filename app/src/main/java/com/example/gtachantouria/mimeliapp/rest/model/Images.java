package com.example.gtachantouria.mimeliapp.rest.model;
import com.google.gson.annotations.SerializedName;

public class Images {
    @SerializedName("id")
    public String id;

    @SerializedName("url")
    public String url;

    @SerializedName("secure_url")
    public String secureUrl;

    @SerializedName("size")
    public String size;

    @SerializedName("max_size")
    public String maxSize;

    @SerializedName("quality")
    public String quality;
}
