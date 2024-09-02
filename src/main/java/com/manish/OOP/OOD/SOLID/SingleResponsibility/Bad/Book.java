package com.manish.OOP.OOD.SOLID.SingleResponsibility.Bad;

public class Book {
    private String name;
    private String authorName;
    private int year;
    private double price;
    private String isbn;

    public Book(String name, String authorName, int year, double price, String isbn) {
        this.name = name;
        this.authorName = authorName;
        this.year = year;
        this.price = price;
        this.isbn = isbn;
    }

    // Getters and setters for Book attributes

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getIsbn() {
        return isbn;
    }
}



