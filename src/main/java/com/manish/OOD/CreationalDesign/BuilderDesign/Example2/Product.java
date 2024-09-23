package com.manish.OOD.CreationalDesign.BuilderDesign.Example2;

// Product Class: Represents the items being added to the order.
// Each product has a name and price.
public class Product {
    private String name;
    private double price;

    // Constructor to initialize a product with its name and price.
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Getters and setters for accessing and modifying product properties.
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
