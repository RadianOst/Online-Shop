package com.codecool;

import com.codecool.view.OnlineShopView;

class OnlineShop{
    private OnlineShopView view;
    private final String MAIN_MENU_TITLE = "Please choose what you want to do";
    private final String[] MAIN_MENU_OPTIONS = {
        "Show products in Store",
        "Add new product",
        "Add new product category",
        "Make new order",
        "Exit program"
    };
    private final String UNKNOWN_OPTION_ERROR = "Option not found";
    private boolean isRunning = true;

    public OnlineShop(){
        view = new OnlineShopView();
    }

    public void run(){
        view.clearConsole();
        view.printWelcomeMessage();
        view.printMenu(MAIN_MENU_TITLE, MAIN_MENU_OPTIONS);
        while(isRunning){
            handleMenu();
        }
    }

    public void handleMenu(){
        int userChoice;

        userChoice = view.getIntInput();
        if (userChoice < 1 || userChoice > MAIN_MENU_OPTIONS.length){
            view.printError(UNKNOWN_OPTION_ERROR);
            return;
        }

        switch(userChoice){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                isRunning = false;
                view.print("Exit"); 
                break;
        }
    }
}