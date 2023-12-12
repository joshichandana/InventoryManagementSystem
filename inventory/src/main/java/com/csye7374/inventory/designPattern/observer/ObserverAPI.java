package com.csye7374.inventory.designPattern.observer;

import com.csye7374.inventory.model.Product;

public abstract class ObserverAPI {
    protected Notify notify;
    public ObserverAPI() {
    }
    public abstract void update(Product product);

}
