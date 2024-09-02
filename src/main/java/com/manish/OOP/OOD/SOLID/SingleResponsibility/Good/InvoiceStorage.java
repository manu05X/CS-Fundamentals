package com.manish.OOP.OOD.SOLID.SingleResponsibility.Good;

public
class InvoiceStorage {
    public void saveToDatabase(Invoice invoice) {
        // Database-saving logic here
        System.out.println("Invoice saved to the database.");
    }
}