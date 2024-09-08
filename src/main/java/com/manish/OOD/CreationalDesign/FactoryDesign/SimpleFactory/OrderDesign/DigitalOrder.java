package com.manish.OOD.CreationalDesign.FactoryDesign.SimpleFactory.OrderDesign;

// Concrete DigitalOrder class that extends the abstract Order class
public class DigitalOrder extends Order {
    @Override
    public void generateInvoice() {
        // Implementation for generating invoice for digital order
        System.out.println("Generating invoice for Digital Order.");
    }
}
