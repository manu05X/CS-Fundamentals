package com.manish.OOD.BehavioralDesign.Strategy.ShippingCost;

public class FreeShippingCostCalculator implements ShippingCostCalculator {
    @Override
    public double calculateShippingCost(double totalPrice) {
        return 0.0; // Free shipping for all products
    }
}
