package com.codecool.order.process;

import com.codecool.order.Orderable;

public class PayProcess extends AbstractProcess {

    public PayProcess(Orderable item) {
        super(item);
    }

    @Override
    protected void action(Orderable item) {
        item.setIsPaid(true);
    }
}