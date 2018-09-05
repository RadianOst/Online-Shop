package com.codecool.order;

import com.codecool.order.process.CheckoutProcess;
import com.codecool.order.process.PayProcess;

public class Order implements Orderable {
    private static int orderCounter = 0;
    private int id;
    private Basket basket;
    private String status;
    private boolean isPaid;
    private boolean isChecked;
    private int orderValue;

    public Order() {
        this.id = 100 + orderCounter;
        orderCounter++;
        this.basket = new Basket();
        this.status = "processing";
        this.isChecked = false;
        this.isPaid = false;
    }

    public int getId() {
        return this.id;
    }

    public String getStatus() {
        return this.status;
    }

    public int getOrderValue() {
        return this.orderValue;
    }

    public Basket getBasket() {
        return this.basket;
    }

    public void setOrderValue(int newValue) {
        this.orderValue = newValue;
    }

    public void setIsChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }

    public void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    public void setStatus(String newStatus) {
        this.status = newStatus;
    }

    public boolean checkout() {
        CheckoutProcess checkoutProcess = new CheckoutProcess(this);
        checkoutProcess.process(this);
        return isChecked;
    }

    public boolean pay() {
        PayProcess payProcess = new PayProcess(this);
        payProcess.process(this);
        return isPaid;
    }

    @Override
    public String toString() {
        String orderToString = "";
        orderToString += "Ordered items: " + getBasket().getListOfItems() + "\n";
        orderToString += "Order's value: " + getOrderValue() + " PLN\n";
        orderToString += "Status: " + getStatus() + "\n";
        return orderToString;
    }
}