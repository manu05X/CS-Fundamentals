package com.manish.OOP.OOD.SOLID.SingleResponsibility.Bad;

public class Invoice {
    private Book book;
    private int quantity;
    private double discountRate;
    private double taxRate;

    public Invoice(Book book, int quantity, double discountRate, double taxRate) {
        this.book = book;
        this.quantity = quantity;
        this.discountRate = discountRate;
        this.taxRate = taxRate;
    }

    public double calculateTotal() {
        double price = ((book.getPrice() - book.getPrice() * discountRate) * this.quantity);
        return price * (1 + taxRate);
    }

    public void printInvoice() {
        System.out.println("Quantity : " + quantity + "x " + book.getName() + " "+"ISBN: " + book.getIsbn()+ " " + book.getPrice() + "$");
        System.out.println("Discount Rate: " + discountRate);
        System.out.println("Tax Rate: " + taxRate);
        System.out.println("Total: " + calculateTotal());//"ISBN " book.getIsbn() +
        //System.out.println("ISBN: " + book.getIsbn());
    }

    public void saveToDatabase() {
        // Logic to save the invoice to the database
        // Implement the database-saving logic here
    }
}