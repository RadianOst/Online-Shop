package com.codecool;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class ProductCategory{
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

    public static List<ProductCategory> getProductCategoryList(){
        return productCategoryList;
    }

    public static ProductCategory getProductCategoryByName(String name) throws InputMismatchException{
        name = name.toLowerCase();
        for (ProductCategory category : productCategoryList){
            if (category.getName().toLowerCase().equals(name)){
                return category;
            }
        }

        throw new InputMismatchException();
    }

    @Override
    public String toString() {
        return name;
    }

    private Integer generateID(){
        return productCategoryList.size() + 1000;
    }
}