package com.codecool.controller;

import java.util.ArrayList;
import java.util.List;

import com.codecool.Product;
import com.codecool.order.Order;
import com.codecool.view.OrderView;

public class OrderController {
    List<Order> orders;

    public OrderController() {
        this.orders = new ArrayList<Order>();
    }

    public void makeOrder() {
        Order order = new Order();
        OrderView orderView = new OrderView(order);
        boolean isFinished = false;

        while (!isFinished) {

        }

    }

    private List<Product> chooseProducts() {
        List<Product> choosenProducts = new ArrayList<Product>();
        return choosenProducts;
    }

}