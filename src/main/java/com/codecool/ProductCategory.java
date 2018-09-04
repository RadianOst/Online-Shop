package com.codecool;

import java.util.ArrayList;
import java.util.List;

class ProductCategory{
    private String name;
    private Integer ID;
    private static List<ProductCategory> productCategoryList = new ArrayList<ProductCategory>();

    public ProductCategory(String name){
        this.name = name;
        ID = generateID();
        productCategoryList.add(this);
    }

    public String getName(){
        return name;
    }

    public List<ProductCategory> getProductCategoryList(){
        return productCategoryList;
    }

    @Override
    public String toString() {
        return name;
    }

    private Integer generateID(){
        return productCategoryList.size();
    }
}