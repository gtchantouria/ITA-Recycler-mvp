package com.example.gtachantouria.mimeliapp.rest.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by guill on 6/26/2017.
 */

public class ItemList {
    @SerializedName("results")
    public List<Item> items;
}
