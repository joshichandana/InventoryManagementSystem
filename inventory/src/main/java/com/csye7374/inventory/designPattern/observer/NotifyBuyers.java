package com.csye7374.inventory.designPattern.observer;

import com.csye7374.inventory.designPattern.facade.SendMessage;
import com.csye7374.inventory.model.Buyer;
import com.csye7374.inventory.model.Product;
import com.csye7374.inventory.repository.BuyerRepository;

import java.util.Iterator;
import java.util.List;

public class NotifyBuyers extends Buyer{
    private List<Buyer> buyers;
    private Product product;
    private BuyerRepository buyerRepo;

    public NotifyBuyers(Product product, BuyerRepository buyerRepo) {
        this.product = product;
        this.buyerRepo = buyerRepo;
    }

    public void notifyAllBuyers() {
        StringBuilder sb = new StringBuilder();
        this.buyers = this.buyerRepo.findAll();
        Iterator var3 = this.buyers.iterator();

        while(var3.hasNext()) {
            Buyer buyer = (Buyer)var3.next();
            System.out.println(buyer.getOwnerName() + " notified of Product " + this.product.getProductName() + " addition");
            sb.append("Hello " + buyer.getOwnerName()).append(", new product available : ");
            sb.append(this.product.getProductName() + "\n");
            SendMessage.message(sb.toString());
        }

    }
}
