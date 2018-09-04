package com.codecool;

import java.util.Date;

class FeaturedProductCategory extends ProductCategory{
    private Date expirationDate;

    public FeaturedProductCategory(String name, Date expirationDate){
        super(name);
        this.expirationDate = expirationDate;
    }
}