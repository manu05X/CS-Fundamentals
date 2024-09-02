package com.manish.OOP.OOD.SOLID.SingleResponsibility.OCP;
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

    // Getters and other methods related to Book

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}