package com.csye7374.inventory.designPattern.observer;

import com.csye7374.inventory.model.Product;
import com.csye7374.inventory.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UpdateDB extends ObserverAPI{
    private ProductRepository productRepo;

    public UpdateDB(Notify notify, ProductRepository productRepo) {
        this.notify = notify;
        this.productRepo = productRepo;
        this.notify.attach(this);
    }

    public void update(Product product) {
        if ((this.productRepo.findByProductName(product.getProductName())).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product already exists");
        } else {
            this.productRepo.save(product);
        }
    }
}
