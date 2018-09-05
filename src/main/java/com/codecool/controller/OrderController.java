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
        List<Product> products = orderView.chooseProducts();
        addProductsToBasket(this.order, products);
    }

    private void addProductsToBasket(Order order, List<Product> products) {
        if (this.order != null) {
            for (Product product : products) {
                order.getBasket().addProduct(product);
            }
        } else {
            System.out.println("\nBasket is empty!\n");
        }
    }

    public void printOrder() {
        if (this.order != null) {
            orderView.printOrder();
        } else {
            System.out.println("\nBasket is empty!\n");
        }
    }

    public void addMoreProductsToBasket() {
        if (this.order != null) {
            List<Product> products = orderView.chooseProducts();
            addProductsToBasket(this.order, products);
        } else {
            System.out.println("\nBasket is empty!\n");
        }
    }

    public void checkoutAndPay() {

        if (this.order != null) {
            this.orderView.printOrderValue();
            String customerData = this.orderView.getCustomerData();
            this.order.checkout();
            this.orderView.printOrder();
            int creditCardNumber = this.orderView.getCreditCardNumber();
            this.order.pay();
            this.orderView.printOrder();
            this.order = null;
        } else {
            System.out.println("\nBasket is empty!\n");
        }
    }

    public void run() {
        boolean isRunning = true;

        while (isRunning) {
            this.orderView.printListOfProducts();
            int choice = this.orderView.chooseOption();

            if (choice == 5)
                isRunning = false;
        }
    }

}