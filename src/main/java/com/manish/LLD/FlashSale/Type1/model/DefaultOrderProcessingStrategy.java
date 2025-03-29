package com.manish.LLD.FlashSale.Type1.model;

import com.manish.LLD.FlashSale.Type1.model.FlashSaleOrder;
import com.manish.LLD.FlashSale.Type1.model.InventoryManager;
import com.manish.LLD.FlashSale.Type1.model.Order;

public class DefaultOrderProcessingStrategy implements OrderProcessingStrategy {

    @Override
    public void processOrder(Order order, InventoryManager inventoryManager) {
        if (!(order instanceof FlashSaleOrder)) {
            throw new IllegalArgumentException("Invalid order type for Flash Sale processing.");
        }

        FlashSaleOrder flashSaleOrder = (FlashSaleOrder) order;

        if (inventoryManager.checkAvailability(flashSaleOrder.getProduct(), flashSaleOrder.getQuantity())) {
            System.out.println("Processing Order for Product: " + flashSaleOrder.getProduct().getName() + ", Quantity: " + flashSaleOrder.getQuantity());
            inventoryManager.updateInventory(flashSaleOrder.getProduct(), -flashSaleOrder.getQuantity());
        } else {
            System.out.println("Insufficient stock for Product: " + flashSaleOrder.getProduct().getName());
        }
    }
}
