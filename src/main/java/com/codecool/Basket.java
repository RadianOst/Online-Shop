package com.codecool;


import com.codecool.Product;

import java.util.ArrayList;
import java.util.Iterator;


public class Basket {

    ArrayList<Product> productList = new ArrayList<Product>();
    

    public Basket(){
        productList = new ArrayList<Product>();
    }

    public Iterator<Product> getIterator(){
        return new ProductIterator();
    }

    private class ProductIterator implements Iterator<Product> {
        int index = 0;
        public boolean hasNext(){
            if( index < productList.size()){
                return true;
            }
            return false;
        }

        public Product next(){
            if(this.hasNext()){
                return productList.get(index++);
            }
            return null;
        }
    }

    public void addProduct(Product product){
        productList.add(product);
    }

    public boolean removeProduct( Product product ){
        if ( productList.contains(product)) {
            productList.remove(product);
            return true;
        }
        return false;
    }

    public ArrayList<Product> getBasket(){
        return productList;
    }

    public String toString(){
        String basketString = "";
        int index = 1;
        for ( Product product : productList ){
            String temString = product.toString();
            basketString = basketString + index + " " + temString + "\n";
            index++;
        }
        return basketString;
    } 

    public Float getBasketValue(){
        ProductIterator productIterarot = new ProductIterator();
        Float sumOfValues = (float)0.00;
        while( productIterarot.hasNext() ){
            Product tempProduct = productIterarot.next();
            Float price = tempProduct.getPrice();
            sumOfValues = sumOfValues + price;
        }
        return sumOfValues;
    }

    public int getSizeOfBasket(){
        ProductIterator productIterarot = new ProductIterator();
        int sumOfProduct = 0;
        while( productIterarot.hasNext() ){
            sumOfProduct = sumOfProduct + 1;
        }
        return sumOfProduct;
    }


}