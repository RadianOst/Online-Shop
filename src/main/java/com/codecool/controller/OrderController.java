package com.codecool.controller;

import java.util.List;

import com.codecool.Product;
import com.codecool.order.Order;
import com.codecool.view.OrderView;

public class OrderController {
    private Order order;
    private OrderView orderView;

    public OrderController() {
    }

    public void makeOrder() {
        this.order = new Order();
        this.orderView = new OrderView(this.order);
        List<Product> products = orderView.chooseProducts();
        addProductsToBasket(this.order, products);
    }

    private void addProductsToBasket(Order order, List<Product> products) {
        for (Product product : products) {
            order.getBasket().addProduct(product);
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
        List<Product> products = orderView.chooseProducts();
        addProductsToBasket(this.order, products);
    }

}