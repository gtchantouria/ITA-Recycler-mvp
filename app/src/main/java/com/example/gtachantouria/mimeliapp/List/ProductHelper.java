package com.example.gtachantouria.mimeliapp.List;

import java.util.ArrayList;
import java.util.List;

public class ProductHelper {
    private List<Product> list;

    public ProductHelper() {
        list = new ArrayList<>();
        list.add(new Product("Product 1"));
        list.add(new Product("Product 2"));
        list.add(new Product("Product 3"));
        list.add(new Product("Product 4"));
        list.add(new Product("Product 5"));
        list.add(new Product("Product 6"));
        list.add(new Product("Product 7"));
        list.add(new Product("Product 8"));
        list.add(new Product("Product 9"));
        list.add(new Product("Product 10"));
    }

    public List<Product> getList() {
        return list;
    }
}
