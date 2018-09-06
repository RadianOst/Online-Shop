package com.codecool;

import java.text.SimpleDateFormat;
import java.util.Date;

class FeaturedProductCategory extends ProductCategory{
    private Date expirationDate;

    public FeaturedProductCategory(String name, Date expirationDate){
        super(name);
        this.expirationDate = expirationDate;
    }

    public Date getExpirationDate(){
        return expirationDate;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = dateFormat.format(expirationDate);
        return String.format("%s, expires: %s", super.toString(), dateString);
    }
}