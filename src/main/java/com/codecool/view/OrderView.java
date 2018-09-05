package com.codecool.view;

import com.codecool.order.Order;

public class OrderView extends View {
    Order order;

    public OrderView(Order order) {
        this.order = order;
    }

    public void printOrder() {
        System.out.println(this.order.getBasket().toString());
        System.out.println("Status: " + this.order.getStatus());
        System.out.println("Price: " + this.order.getOrderValue());
    }

}