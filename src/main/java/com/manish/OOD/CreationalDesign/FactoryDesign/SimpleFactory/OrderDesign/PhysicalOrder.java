package com.manish.OOD.CreationalDesign.FactoryDesign.SimpleFactory.OrderDesign;

// Concrete PhysicalOrder class that extends the abstract Order class
public class PhysicalOrder extends Order {
    @Override
    public void generateInvoice() {
        // Implementation for generating invoice for physical order
        System.out.println("Generating invoice for Physical Order.");
    }
}
