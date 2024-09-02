package com.manish.OOP.OOD.SOLID.SingleResponsibility.Good;
public class Runner {
    public static void main(String[] args) {
        Book book = new Book("The Java Programming Language", "James Gosling", 2022, 49.99);
        System.out.println("ISBN: " + book.getIsbn());
        Invoice invoice = new Invoice(book, 2, 0.1, 0.05);

        InvoicePrinter invoicePrinter = new InvoicePrinter();
        invoicePrinter.printInvoice(invoice);

        InvoiceStorage invoiceStorage = new InvoiceStorage();
        invoiceStorage.saveToDatabase(invoice);
    }
}

