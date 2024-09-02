package com.manish.OOP.OOD.SOLID.SingleResponsibility.Good;

import java.util.UUID;

public class Book {
    private String name;
    private String authorName;
    private int year;
    private double price;
    private UUID isbn;

    public Book(String name, String authorName, int year, double price) {
        this.name = name;
        this.authorName = authorName;
        this.year = year;
        this.price = price;
        this.isbn = UUID.randomUUID();
    }

    // Getters and setters for Book class
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public UUID getIsbn() {
        return isbn;
    }

    public void setIsbn(UUID isbn) {
        this.isbn = isbn;
    }

}
