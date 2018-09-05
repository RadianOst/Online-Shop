package com.codecool.view;

import com.codecool.Product;
import java.util.*;
import java.util.Scanner;

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


    Scanner scanner;

    public String getInput() {
        scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();
        return input;
    }

    public int getIntInput() {
        scanner = new Scanner(System.in);
        boolean isInt = false;
        Integer integer = null;

        while(!isInt && integer != null) {
            String input = scanner.nextLine(); 
            try {
                integer = Integer.parseInt(input);
                isInt = true;
            } catch (NumberFormatException e) {
                System.out.println("Type a number!");
            }
        }
        scanner.close();

        return integer;
    }


}