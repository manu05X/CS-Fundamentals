package com.manish.OOD.CreationalDesign.FactoryDesign.OrderDesign;

// Abstract Order class
public abstract class Order {
    // Abstract method that concrete classes will implement to generate invoices
    public abstract void generateInvoice();
}

