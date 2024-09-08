package com.manish.OOD.BehavioralDesign.Strategy.ShippingCost;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (Product product : products) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }

    public double getShippingCost(ShippingCostCalculator calculator) {
        double totalPrice = getTotalPrice();
        ShippingCostContext context = new ShippingCostContext(calculator);
        return context.calculateShippingCost(totalPrice);
    }
}
