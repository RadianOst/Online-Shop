package com.codecool.view;

import java.util.ArrayList;

import com.codecool.StoreDAO;
import com.codecool.order.Order;
import com.codecool.*;

public class OrderView extends View{
    Order order;
    StoreDAO storeDAO;

    public OrderView(Order order) {
        this.order = order;
    }

}