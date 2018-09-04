package com.codecool.order;

public interface Orderable {
    public boolean checkout();

    public boolean pay();

    public void setStatus(String newStatus);

    public void setIsPaid(boolean newValue);

    public void setIsChecked(boolean newValue);

    public void setOrderValue(int newValue);

    public Basket getBasket();
}