package com.manish.LLD.FlashSale.Type1.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class FlashSaleOrder implements Order {
   private Product product;
   private int quantity;

   public FlashSaleOrder(Product product, int quantity){
       this.product = product;
       this.quantity = quantity;
   }

    @Override
    public void execute() {
        InventoryManager inventoryManager = InventoryManager.getInstance();
        if(inventoryManager.checkAvailability(product,quantity)){
            //Process the order
            inventoryManager.updateInventory(product, -quantity);
            System.out.println("Order processed for Product: " +product.getName() + ", Quantity " +quantity);
        } else {
            System.out.println("Insufficient Product: " +product.getName());
        }
    }
}
