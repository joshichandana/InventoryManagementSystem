package com.csye7374.inventory.designPattern.state;

import com.csye7374.inventory.model.Product;
import com.csye7374.inventory.repository.ProductRepository;

public class StockUpdate extends StateAPI {
    Product product;
    ProductRepository productRepo;

    public StockUpdate(Product product, ProductRepository productRepo) {
        this.product = product;
        this.productRepo = productRepo;
    }

    public void action(State state, int stock) {
        this.product.setQuantity(stock);
//        this.productRepo.update(this.product);
    }
}

