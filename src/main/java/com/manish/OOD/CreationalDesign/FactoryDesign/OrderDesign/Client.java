package com.manish.OOD.CreationalDesign.FactoryDesign.OrderDesign;

// Client code that uses the factory to create orders and generate invoices
public class Client {
    public static void main(String[] args) {
        // Create a PhysicalOrder using the OrderFactory and generate an invoice
        Order physicalOrder = OrderFactory.createOrder("Physical");
        physicalOrder.generateInvoice();

        // Create a DigitalOrder using the OrderFactory and generate an invoice
        Order digitalOrder = OrderFactory.createOrder("Digital");
        digitalOrder.generateInvoice();

        // Create a ServiceOrder using the OrderFactory and generate an invoice
        Order serviceOrder = OrderFactory.createOrder("Service");
        serviceOrder.generateInvoice();
    }
}
