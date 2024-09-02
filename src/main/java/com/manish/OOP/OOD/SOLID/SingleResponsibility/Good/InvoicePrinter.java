package com.manish.OOP.OOD.SOLID.SingleResponsibility.Good;

public class InvoicePrinter {
    public void printInvoice(Invoice invoice) {
        System.out.println(invoice.getQuantity() + "x " + invoice.getBook().getName() + " " + invoice.getBook().getPrice() + "$");
        System.out.println("Discount Rate: " + invoice.getDiscount());
        System.out.println("Tax Rate: " + invoice.getTax());
        System.out.println("Total: " + invoice.calculateTotal());
    }
}
