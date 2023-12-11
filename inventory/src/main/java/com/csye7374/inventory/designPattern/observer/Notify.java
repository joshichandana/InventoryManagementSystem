package com.csye7374.inventory.designPattern.observer;

import com.csye7374.inventory.model.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Notify {
    private List<ObserverAPI> subscribers = new ArrayList();

    public Notify() {
    }

    public void setState(Product product) {
        this.notifyAllSubscribers(product);
    }

    public void attach(ObserverAPI sub) {
        this.subscribers.add(sub);
    }

    public void notifyAllSubscribers(Product product) {
        Iterator var3 = this.subscribers.iterator();

        while(var3.hasNext()) {
            ObserverAPI observer = (ObserverAPI)var3.next();
            observer.update(product);
        }

    }
}
