package com.example.gtachantouria.mimeliapp.List;

public class Product {
    private String Name;

    public Product(String name){
        this.Name = name;
    }

    public void setName(String value){
        this.Name = value;
    }

    public String getName(){
        return this.Name;
    }
}
