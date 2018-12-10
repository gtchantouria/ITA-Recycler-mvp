package com.example.gtachantouria.mimeliapp.ItemsList;

public class Product {
    private String name;
    private String photo;

    public Product(String name){
        this.name = name;
    }

    public void setName(String value){
        this.name = value;
    }

    public String getName(){
        return this.name;
    }

    public void setPhoto(String url){
        this.photo = url;
    }

    public String getPhoto(){
        return this.photo;
    }
}
