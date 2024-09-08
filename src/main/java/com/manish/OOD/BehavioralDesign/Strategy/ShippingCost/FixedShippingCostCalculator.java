package com.manish.OOD.BehavioralDesign.Strategy.ShippingCost;

public class FixedShippingCostCalculator implements ShippingCostCalculator {
    private double fixedCost;

    public FixedShippingCostCalculator(double fixedCost) {
        this.fixedCost = fixedCost;
    }

    @Override
    public double calculateShippingCost(double totalPrice) {
        return fixedCost; // Fixed cost for all products
    }
}
