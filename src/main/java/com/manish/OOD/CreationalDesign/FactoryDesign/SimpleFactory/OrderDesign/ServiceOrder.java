package com.manish.OOD.CreationalDesign.FactoryDesign.SimpleFactory.OrderDesign;

// Concrete ServiceOrder class that extends the abstract Order class
public class ServiceOrder extends Order {
    @Override
    public void generateInvoice() {
        // Implementation for generating invoice for service order
        System.out.println("Generating invoice for Service Order.");
    }
}
