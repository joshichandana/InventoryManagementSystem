package com.csye7374.inventory.designPattern.state;

import com.csye7374.inventory.designPattern.facade.SendMessage;
import com.csye7374.inventory.model.Product;
import com.csye7374.inventory.repository.ProductRepository;

public class StockAlert extends StateAPI {
    Product product;
    ProductRepository productRepo;

    public StockAlert(Product product, ProductRepository productRepo) {
        this.product = product;
        this.productRepo = productRepo;
    }

    public void action(State state, int stock) {
        SendMessage.message("\n******\nLOW STOCK for " + this.product.getProductName() + "\n*****\n");
        this.product.setQuantity(stock);
//        this.productRepo.update(this.product);
    }
}

