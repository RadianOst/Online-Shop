package com.codecool.view;

import java.util.ArrayList;
import java.util.List;

import com.codecool.Product;
import com.codecool.controller.OrderController;
import com.codecool.order.Order;

public class OrderView extends View {
    Order order;
    OrderController orderController;

    public OrderView(Order order, OrderController orderController) {
        this.order = order;
        this.orderController = orderController;
    }

    public void printOrder() {
        System.out.println(this.order.getBasket().toString());
        System.out.println("Status: " + this.order.getStatus());
        System.out.println("Price: " + this.order.getOrderValue());
    }

    public List<Product> chooseProducts() {
        List<Product> products = new ArrayList<Product>();
        boolean isFinished = false;

        while (!isFinished) {
            printListOfProducts();
            System.out.println("\nChoose number of product to add: ");
            int choice = chooseNumberOfProduct();
            products.add(Product.getAllProducts().get(choice));
            Product.getAllProducts().remove(choice);
            finishOrder(isFinished);
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

    private void finishOrder(boolean isFinished) {
        System.out.println("Would you like to add some more products?");
        boolean answerCorrect = false;

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
    }

    public void printOrderMenu() {
        String[] menuOptions = { "Make order", "Add more products", "Show the basket", "Checkout & pay", "Exit" };
        int counter = 1;

        for (String option : menuOptions) {
            System.out.println(counter++ + ". " + option);
        }
    }

    public int chooseOption() {
        System.out.print("\nChoose option: ");
        int choice = getIntInput();

        switch (choice) {
        case 1:
            this.orderController.makeOrder();
            break;
        case 2:
            this.orderController.addMoreProductsToBasket();
            break;
        case 3:
            this.orderController.printOrder();
            break;
        case 4:
            break;
        case 5:
            break;
        default:
            System.out.println("Unknown choice!");
        }

        return choice;

    }

}