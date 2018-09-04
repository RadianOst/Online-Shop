package com.codecool;

import java.util.List;
import java.util.ArrayList;

class Product{
    private String name;
    private Float price;
    private ProductCategory productCategory;
    private Integer ID;
    private static List<Product> productList = new ArrayList<Product>();

    private final int NAME_TEXT_WIDTH = 15;
    private final int PRICE_TEXT_WIDTH = 6;
    private final int CATEGORY_TEXT_WIDTH = 15;

    public Product(String name, Float defaultPrice, ProductCategory productCategory){
        this.name = name;
        price = defaultPrice;
        this.productCategory = productCategory;
        ID = generateID();
        productList.add(this);
    }

    public String getName(){
        return name;
    }

    public Float getPrice(){
        return price;
    }

    public ProductCategory getProductCategory(){
        return productCategory;
    }

    public List<Product> getAllProducts(){
        return productList;
    }

    public List<Product> getAllProductsByCategory(ProductCategory productCategory){
        List<Product> productsByCategoryList = new ArrayList<Product>();

        for (Product product : productList){
            if (product.getProductCategory().equals(productCategory)){
                productsByCategoryList.add(product);
            }
        }

        return productsByCategoryList;
    }

    @Override
    public String toString() {
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append(String.format("%-" + NAME_TEXT_WIDTH + "s", name));
        sBuilder.append(String.format(" | Price: %" + PRICE_TEXT_WIDTH + ".2f zl", price));
        sBuilder.append(String.format(" | %-" + CATEGORY_TEXT_WIDTH + "s", productCategory.toString()));
        return sBuilder.toString();
    }

    private Integer generateID(){
        return productList.size();
    }
}