package com.csye7374.inventory.controller;

import com.csye7374.inventory.designPattern.strategy.BuyerStrategy;
import com.csye7374.inventory.designPattern.strategy.InventoryStrategy;
import com.csye7374.inventory.model.Buyer;
import com.csye7374.inventory.repository.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @apiNote - Controller for Buyers
 */
@RestController
@RequestMapping("/buyer")
public class BuyerController {

    // Dependency Injection by Autowiring for Buyer Repo
    @Autowired
    private BuyerRepository buyerRepo;

    // Getting All the buyers
    @GetMapping("/getAll")
    public List<Buyer> getAll() {
        return buyerRepo.findAll();
    }

    // Saving the buyer data in DB
    @PostMapping("/save")
    public void save(@RequestBody Buyer buyer) {
        InventoryStrategy strategy = new InventoryStrategy(new BuyerStrategy(buyerRepo, buyer));
        strategy.executeAdd();
    }

    // Get specific Buyer
    @GetMapping("/getBuyer/{id}")
    public Buyer getBuyer(@PathVariable int id) {
        return buyerRepo.findById(id).get();
    }

    // Delete Specific Buyer
    @DeleteMapping("/delete/{id}")
    public void deletebyID(@PathVariable int id) {
        InventoryStrategy strategy = new InventoryStrategy(new BuyerStrategy(buyerRepo, id));
        strategy.executeDelete();
    }

    // Update Buyer Info
    @PutMapping("/update/{id}")
    public void update(@RequestBody Buyer buyer, @PathVariable int id) {
        InventoryStrategy strategy = new InventoryStrategy(new BuyerStrategy(buyerRepo, buyer));
        strategy.executeUpdate(id);
    }

}