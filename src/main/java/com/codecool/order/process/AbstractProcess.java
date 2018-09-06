package com.codecool.order.process;

import com.codecool.order.Orderable;

public abstract class AbstractProcess {
    private Orderable item;

    public AbstractProcess(Orderable item) {

        this.item = item;
    }

    public void process(Orderable item) {
        action(item);
    }

    public void stepBefore() {
        item.setStatus("checked");
    }

    protected abstract void action(Orderable item);

    public void stepAfter() {
        this.item.setStatus("paid");
    }
}