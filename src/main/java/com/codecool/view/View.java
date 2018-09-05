package com.codecool.view;

import com.codecool.Product;
import java.util.*;

/**
 * View
 * 
 */
public abstract class View<Product> {

    Product product;

    public abstract void printView();
    public abstract void printMenu();

    public void printTitle( String title ){
        System.out.println(title);
    }

    public void print( String string ){
        System.out.println( string );
    }
   
    public void print( ArrayList<Product> productList ){
        for ( Product  product : productList ){
            product.toString();
        }
    }

    public void print( Product product ){
        System.out.println(product.toString());
    }

    
}