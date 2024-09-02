package com.manish.OOP.OOD.SOLID.SingleResponsibility.OCP;

public class Invoice {
    private Book book;
    private int quantity;
    private double discount;
    private double tax;

    public Invoice(Book book, int quantity, double discount, double tax) {
        this.book = book;
        this.quantity = quantity;
        this.discount = discount;
        this.tax = tax;
    }

    public double calculateTotal() {
        double price = ((book.getPrice() - book.getPrice() * discount) * this.quantity);
        return price * (1 + tax);
    }

    // Getters for Invoice class

    public Book getBook() {
        return book;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getDiscount() {
        return discount;
    }

    public double getTax() {
        return tax;
    }

    // Other getters
}