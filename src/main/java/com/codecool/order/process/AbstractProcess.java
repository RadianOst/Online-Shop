package com.codecool.order.process;

import com.codecool.order.Orderable;

public abstract class AbstractProcess {
    private Orderable item;

    public AbstractProcess(Orderable item) {

        this.item = item;
    }

    public void process(Orderable item) {
        stepBefore();
        action(item);
        stepAfter();
    }

    public void stepBefore() {
        if (getClass().getCanonicalName().equals("CheckoutProcess")) {
            item.setStatus("checked");
        } else {
            item.setStatus("finalized");
        }
    }

    protected abstract void action(Orderable item);

    public void stepAfter() {
        if (getClass().getCanonicalName().equals("CheckoutProcess")) {
            item.setOrderValue(item.getBasket().getBasketValue());
        } else {
            item.setStatus("sent");
        }

    }
}