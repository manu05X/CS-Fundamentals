package com.manish.OOP.OOD.SOLID.SingleResponsibility.OCP;

public class Runner {
    public static void main(String[] args) {
        Book book = new Book("The Java Programming Language", "James Gosling", 2022, 49.99);
        Invoice invoice = new Invoice(book, 2, 0.1, 0.05);

        InvoiceAction invoicePrinter = new InvoicePrinter();
        InvoiceAction invoiceStorage = new InvoiceStorage();

        invoicePrinter.perform(invoice);
        invoiceStorage.perform(invoice);
    }
}
