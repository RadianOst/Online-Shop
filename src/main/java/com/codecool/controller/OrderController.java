package com.codecool.controller;

import java.util.List;

import com.codecool.Product;
import com.codecool.order.Order;
import com.codecool.view.OrderView;

public class OrderController {
    private Order order;
    private OrderView orderView;

    public OrderController() {
        this.order = new Order();
        this.orderView = new OrderView(this.order, this);
    }

    public void makeOrder() {
        if (this.order == null) {
            this.order = new Order();
        }

        List<Product> products = orderView.chooseProducts();
        addProductsToBasket(this.order, products);
    }

    private void addProductsToBasket(Order order, List<Product> products) {
        for (Product product : products) {
            order.getBasket().addProduct(product);
        }
    }

    public void printOrder() {
        if (!this.order.isEmpty()) {
            orderView.printOrder();
        } else {
            System.out.println("\nBasket is empty!\n");
            this.orderView.getInput();
        }
    }

    public void addMoreProductsToBasket() {
        if (!this.order.isEmpty()) {
            List<Product> products = orderView.chooseProducts();
            addProductsToBasket(this.order, products);
        } else {
            System.out.println("Order is not made yet! Choose option 'Make order'");
            this.orderView.getInput();
        }
    }

    public void checkoutAndPay() {

        if (!this.order.isEmpty()) {
            this.orderView.printOrderValue();
            String customerData = this.orderView.getCustomerData();
            this.order.checkout();
            this.orderView.printOrder();
            int creditCardNumber = this.orderView.getCreditCardNumber();
            this.order.pay();
            this.orderView.printOrder();
            this.order = new Order();
        } else {
            System.out.println("\nBasket is empty!\n");
            this.orderView.getInput();
        }
    }

    public void run() {
        boolean isRunning = true;

        while (isRunning) {
            this.orderView.clearConsole();
            this.orderView.printOrderMenu();
            int choice = this.orderView.chooseOption();

            if (choice == 5)
                isRunning = false;
        }
    }

}