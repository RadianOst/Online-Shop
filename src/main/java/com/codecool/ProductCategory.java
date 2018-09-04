package com.codecool;

import java.util.ArrayList;
import java.util.List;

class ProductCategory{
    private String name;
    private Integer ID;
    private static List<ProductCategory> categoryList = new ArrayList<ProductCategory>();

    public ProductCategory(String name){
        this.name = name;
        ID = generateID();
        categoryList.add(this);
    }

    @Override
    public String toString() {
        return name;
    }

    private Integer generateID(){
        return categoryList.size();
    }
}