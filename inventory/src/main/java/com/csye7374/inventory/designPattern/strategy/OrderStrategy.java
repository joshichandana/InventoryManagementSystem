package com.csye7374.inventory.designPattern.strategy;

import com.csye7374.inventory.InventoryCartAPI;
import com.csye7374.inventory.designPattern.state.State;
import com.csye7374.inventory.designPattern.state.StateAPI;
import com.csye7374.inventory.designPattern.state.StockAlert;
import com.csye7374.inventory.designPattern.state.StockUpdate;
import com.csye7374.inventory.model.ProductPO;
import com.csye7374.inventory.model.PurchaseOrder;
import com.csye7374.inventory.repository.OrderRepository;
import com.csye7374.inventory.repository.ProductPORepository;
import com.csye7374.inventory.repository.ProductRepository;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class OrderStrategy implements StrategyAPI {
    private final OrderRepository orderRepo;
    private ProductRepository productRepo;
    private int id;
    private PurchaseOrder purchaseOrder;
    private PurchaseOrder insertedPO;

    public OrderStrategy(OrderRepository orderRepo, ProductRepository productRepo, PurchaseOrder insertedPO, PurchaseOrder purchaseOrder) {
        this.orderRepo = orderRepo;
        this.productRepo = productRepo;
        this.purchaseOrder = purchaseOrder;
        this.insertedPO = insertedPO;
    }

    public OrderStrategy(OrderRepository orderRepo, PurchaseOrder purchaseOrder) {
        this.orderRepo = orderRepo;
        this.purchaseOrder = purchaseOrder;
    }

    public OrderStrategy(OrderRepository orderRepo, int id) {
        this.orderRepo = orderRepo;
        this.id = id;
    }
    @Override
    public void add() {
        InventoryCartAPI cart = new InventoryCartAPI() {
            @Override
            public double getCost() {
                return 0;
            }
        };
        System.out.println("Inserted " + this.insertedPO.getId());
        List<ProductPO> productPOs = this.insertedPO.getProducts();
        Iterator var4 = productPOs.iterator();

        while(var4.hasNext()) {
            ProductPO proPO = (ProductPO)var4.next();
            StateAPI state;
            com.csye7374.inventory.model.Product product = proPO.getProduct();
            cart = new InventoryCartAPI((InventoryCartAPI) cart, product, proPO) {
                @Override
                public double getCost() {
                    return 0;
                }
            };
            int difference = product.getQuantity() - proPO.getQuantity();
            int count =0;
            if (difference <= 100) {
                state = new StockAlert(product, this.productRepo);
                count = difference;
            } else {
                state = new StockUpdate(product, this.productRepo);
                count = proPO.getQuantity()*2;
            }
            state.action(count);
        }
    }

    @Override
    public void update(int id) {
        Optional<PurchaseOrder> purchaseOrder = this.orderRepo.findById(id);
        if (purchaseOrder.isEmpty()) {
            throw new RuntimeException("Purchase Order does not exist");
        }
        purchaseOrder.get().setProducts(this.purchaseOrder.getProducts());
        purchaseOrder.get().setBuyer(this.purchaseOrder.getBuyer());
        purchaseOrder.get().setTotalAmount(this.purchaseOrder.getTotalAmount());
        purchaseOrder.get().setPaid(this.purchaseOrder.isPaid());
        purchaseOrder.get().setInvoice(this.purchaseOrder.getInvoice());
        purchaseOrder.get().setPaymentDueDate(this.purchaseOrder.getPaymentDueDate());
        this.orderRepo.save(purchaseOrder.get());
    }

    @Override
    public void delete() {
        Optional<PurchaseOrder> purchaseOrder = this.orderRepo.findById(this.id);
        this.orderRepo.delete(purchaseOrder.get());
    }
}
