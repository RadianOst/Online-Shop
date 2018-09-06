package com.codecool.view;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class OnlineShopView extends View{
    private final String WELCOME_MESSAGE = "Welcome to Online Shop!";
    private final int MENU_WIDTH = 20;
    private final int MENU_DELAY_IN_SECONDS = 2;

    public void printWelcomeMessage(){
        System.out.println(center(WELCOME_MESSAGE, MENU_WIDTH)+"\n\n");
    }

    public void printMenu(String menuTitle, String[] options){
        printCentered(menuTitle+"\n", MENU_WIDTH);
        waitForSeconds(MENU_DELAY_IN_SECONDS);
        super.printMenu(options);
    }

    public void printError(String error){
        printCenteredError(String.format("!!! %s !!!", error), MENU_WIDTH);
    }
}