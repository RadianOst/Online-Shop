package com.codecool.view;

import java.util.List;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.codecool.Product;
import com.codecool.ProductCategory;

public class OnlineShopView extends View{
    private final String WELCOME_MESSAGE = "Welcome to Online Shop!";
    private final int MENU_WIDTH = 30;

    public void printWelcomeMessage(){
        println(center(WELCOME_MESSAGE, MENU_WIDTH)+"\n\n");
    }

    public void printMenu(String menuTitle, String[] options){
        printCentered(menuTitle+"\n", MENU_WIDTH);
        super.printMenu(options);
    }

    public void printCentered(String message) {
        super.printCentered(message, MENU_WIDTH);;
    }

    public void printError(String error){
        printCenteredError(error, MENU_WIDTH);
    }

    public void printProducts(List<Product> products){
        if (products.size() == 0){
            println("The store is empty.");
            return;
        }

        for (Product product : products){
            println(String.format("\t%s", product.toString()));
        }
    }

    public void printProductCategories(){
        List<ProductCategory> categories = ProductCategory.getProductCategoryList();
        
        if (categories.size() == 0){
            println("There's no product categories yet.");
            return;
        }

        for (ProductCategory category : categories){
            println(String.format("\t%s", category.toString()));
        }
    }

    public Date getDateFromUser(){
        final String DATE_FORMAT = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
        String input;
        boolean isValidDate = false;
        Date date = null;

        while (!isValidDate){
            println(String.format("Please enter a date: (%s)", DATE_FORMAT));
            input = getInput();
            try{
                date = simpleDateFormat.parse(input);
                isValidDate = true;
            } catch (ParseException e){
                printError("Cannot convert input into date");
            }
        }

        return date;
    }
}