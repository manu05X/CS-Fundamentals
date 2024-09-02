package com.manish.OOP.OOD.SOLID.SingleResponsibility.OCP;

public class InvoiceStorage implements InvoiceAction {
    @Override
    public void perform(Invoice invoice) {
        // Database-saving logic here
        System.out.println("Invoice saved to the database.");
    }
}