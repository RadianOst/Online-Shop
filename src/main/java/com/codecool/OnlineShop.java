package com.codecool;

import java.util.InputMismatchException;
import java.util.Date;

import com.codecool.controller.OrderController;
import com.codecool.view.OnlineShopView;

class OnlineShop{
    private OnlineShopView view;
    private final String MAIN_MENU_TITLE = "Please choose what you want to do";
    private final String[] MAIN_MENU_OPTIONS = {
        "Show products in Store",
        "Add new product",
        "Show product categories",
        "Add new product category",
        "Make new order",
        "Exit program"
    };
    private final String UNKNOWN_OPTION_ERROR = "Option not found";
    private final float MENU_DELAY_IN_SECONDS = 1.5f;
    private boolean isRunning = true;
    private StoreDAO storeDAO;

    public OnlineShop(){
        view = new OnlineShopView();
        storeDAO = new StoreDAO();
    }

    public void run(){
        view.clearConsole();
        view.printWelcomeMessage();
        view.waitForSeconds(MENU_DELAY_IN_SECONDS);
        while(isRunning){
            view.clearConsole();
            view.printWelcomeMessage();
            view.printMenu(MAIN_MENU_TITLE, MAIN_MENU_OPTIONS);
            handleMenu();
        }
    }

    public void handleMenu(){
        int userChoice = view.getIntInput();

        switch(userChoice){
            case 1:
                printProductsInStore();
                break;
            case 2:
                addNewProduct();
                break;
            case 3:
                showProductCategories();
                break;
            case 4:
                addNewProductCategory();
                break;
            case 5:
                new OrderController().run();
                break;
            case 6:
                isRunning = false; 
                storeDAO.exportToTXT();
                view.printCentered("See you again!");
                break;
            default:
                view.printError(UNKNOWN_OPTION_ERROR);
        }

        view.waitForAction();
    }

    private void printProductsInStore(){
        view.println("Products in store:");
        view.printProducts(Product.getAllProducts());
    }

    private void addNewProduct(){
        if (ProductCategory.getProductCategoryList().size() == 0){
            view.println("There's no product categories yet. Please create one first.");
            return;
        }

        String name = view.askForInput("Please enter a product name:");
        Float defaultPrice = null;
        while (defaultPrice == null){
            try{
                defaultPrice = Float.valueOf(view.askForInput("Please enter a default price"));
            } catch (NumberFormatException e){
                view.printError("Please enter a number in given format: 0.00");
            }
        }
        showProductCategories();
        String categoryName = view.askForInput("Please choose a category from the list above:");
        ProductCategory productCategory = null;

        while (productCategory == null){
            try{
                productCategory = ProductCategory.getProductCategoryByName(categoryName);
            } catch (InputMismatchException e){
                view.printError("Cannot find given category. Try again.");
            }
        }

        storeDAO.addProduct(new Product(name, defaultPrice, productCategory));
        view.printCentered(String.format("%s created sucessfully!", name));
    }

    private void showProductCategories(){
        view.println("Available categories:");
        view.printProductCategories();
    }

    private void addNewProductCategory(){
        boolean nameAlreadyExists = true;
        String name = "";
        do{
            name = view.askForInput("Please enter a product category name");
            try{
                ProductCategory.getProductCategoryByName(name);
                view.printError("Given product category already exist");
            } catch (InputMismatchException e){
                nameAlreadyExists = false;
            }
        }
        while (nameAlreadyExists);

        String isFeaturedString = view.askForInput("Is it a featured category? (yes/no)");
        boolean isFeatured = parseStringToBoolean(isFeaturedString);

        if (isFeatured){
            Date expirationDate = view.getDateFromUser();
            new FeaturedProductCategory(name, expirationDate);
        } else {
            new ProductCategory(name);
        }
        view.printCentered(String.format("%s category created sucessfully!", name));
    }

    private boolean parseStringToBoolean(String text){
        final String[] POSITIVE_ANSWERS = {"yes", "true", "y"};
        
        text = text.toLowerCase();

        for (String answer : POSITIVE_ANSWERS){
            if (text.equals(answer)){
                return true;
            }
        }

        return false;
    }
}