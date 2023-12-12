package com.csye7374.inventory.designPattern.state;

import com.csye7374.inventory.model.Product;
import com.csye7374.inventory.repository.ProductRepository;

public class StockUpdate implements StateAPI {
    Product product;
    ProductRepository productRepo;

    public StockUpdate(Product product, ProductRepository productRepo) {
        this.product = product;
        this.productRepo = productRepo;
    }

    public void action(int stock) {
        this.product.setQuantity(stock);
        this.productRepo.save(this.product);
    }
}

