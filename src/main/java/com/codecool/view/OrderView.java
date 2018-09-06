package com.codecool.view;

import java.util.ArrayList;
import java.util.List;

import com.codecool.Product;
import com.codecool.controller.OrderController;
import com.codecool.order.Order;

public class OrderView extends View {
    private Order order;
    private OrderController orderController;

    public OrderView(Order order, OrderController orderController) {
        this.order = order;
        this.orderController = orderController;
    }

    public void printOrder() {
        System.out.println(this.order.getBasket().toString());
        System.out.println("Status: " + this.order.getStatus());
        System.out.println("Price: " + this.order.getOrderValue());
        getInput();
    }

    public List<Product> chooseProducts() {
        List<Product> products = new ArrayList<Product>();
        boolean isFinished = false;

        while (!isFinished) {
            clearConsole();
            printListOfProducts();
            System.out.println("\nChoose number of product to add: ");
            int choice = chooseNumberOfProduct();
            products.add(Product.getAllProducts().get(choice));
            Product.getAllProducts().remove(choice);
            isFinished = isOrderFinished();
        }
        return products;
    }

    public void printListOfProducts() {
        for (int i = 0; i < Product.getAllProducts().size(); i++) {
            System.out.println((i + 1) + ". " + Product.getAllProducts().get(i).toString());
        }
    }

    private int chooseNumberOfProduct() {
        boolean isChoiceCorrect = false;
        int choice = -1;

        while (!isChoiceCorrect || choice < 0) {
            choice = getIntInput();
            if (choice <= Product.getAllProducts().size() && choice > 0) {
                isChoiceCorrect = true;
            } else {
                System.out.println("Choose correct number of product!");
            }
        }
        return choice - 1;
    }

    private boolean isOrderFinished() {
        System.out.println("Would you like to add some more products?");
        boolean answerCorrect = false;
        boolean isFinished = false;

        while (!answerCorrect) {
            String answer = getInput().toLowerCase().trim();

            if (answer.equals("no")) {
                isFinished = true;
                answerCorrect = true;
            } else if (answer.equals("yes")) {
                isFinished = false;
                answerCorrect = true;
            } else {
                System.out.println("Wrong answer! Type 'yes' or 'no'.");
            }
        }
        return isFinished;
    }

    public void printOrderMenu() {
        String[] menuOptions = { "Make order", "Add more products", "Show the basket", "Checkout & pay", "Exit" };
        int counter = 1;

        for (String option : menuOptions) {
            System.out.println(counter++ + ". " + option);
        }
    }

    public int chooseOption() {
        System.out.println("\nChoose option: ");
        int choice = getIntInput();

        switch (choice) {
        case 1:
            clearConsole();
            this.orderController.makeOrder();
            break;
        case 2:
            clearConsole();
            this.orderController.addMoreProductsToBasket();
            break;
        case 3:
            clearConsole();
            this.orderController.printOrder();
            break;
        case 4:
            clearConsole();
            this.orderController.checkoutAndPay();
            break;
        case 5:
            clearConsole();
            choice = exitQuestion();
            break;
        default:
            System.out.println("Unknown choice!");
        }

        return choice;

    }

    public void printOrderValue() {
        System.out.println("Your order value: " + this.order.getOrderValue());
    }

    public String getCustomerData() {
        System.out.println("Type your name and surname: ");
        String name = getInput();
        System.out.println("Type your address: ");
        String adrress = getInput();
        System.out.println("Type your email: ");
        String email = getInput();

        return name + "\n" + adrress + "\n" + email;
    }

    public int getCreditCardNumber() {
        System.out.println("Type your credit card's number: ");
        int creditCardNumber = getIntInput();
        return creditCardNumber;
    }

    public int exitQuestion() {
        int choice = 5;
        System.out.println("All unprocessed orders will be lost! Are you sure? (type 'yes' to confirm)");
        String answer = getInput().trim().toLowerCase();
        if (!answer.equals("yes"))
            choice = 0;

        return choice;
    }

}