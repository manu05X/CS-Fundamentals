package com.manish.OOD.CreationalDesign.FactoryDesign.SimpleFactory.OrderDesign;

// Abstract Order class
public abstract class Order {
    // Abstract method that concrete classes will implement to generate invoices
    public abstract void generateInvoice();
}

