package com.codecool.order.process;

import com.codecool.order.Orderable;

public class CheckoutProcess extends AbstractProcess {

    public CheckoutProcess(Orderable item) {
        super(item);
    }

    @Override
    protected void action(Orderable item) {
        item.setIsChecked(true);
    }
}