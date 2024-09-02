package com.manish.OOP.OOD.SOLID.SingleResponsibility.Bad;

public class Runner {
    public static void main(String[] args) {
        Book book = new Book("The Java Programming Language", "James Gosling", 2022, 49.99, "III1234987");
        Invoice invoice = new Invoice(book, 2, 0.1, 0.05);

        invoice.printInvoice();
        invoice.saveToDatabase();
    }
}

/*
import java.util.UUID;

class Book {
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
}

class Invoice {
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

    public void printInvoice() {
        System.out.println(quantity + "x " + book.getName() + " " + book.getPrice() + "$");
        System.out.println("Discount Rate: " + discount);
        System.out.println("Tax Rate: " + tax);
        System.out.println("Total: " + calculateTotal());
    }

    public void saveToDatabase() {
        // Database-saving logic here
        System.out.println("Invoice saved to the database.");
    }
}

public class Main {
    public static void main(String[] args) {
        Book book = new Book("The Java Programming Language", "James Gosling", 2022, 49.99);
        Invoice invoice = new Invoice(book, 2, 0.1, 0.05);

        invoice.printInvoice();
        invoice.saveToDatabase();
    }
}


*/
/*
import java.util.UUID;

class Book {
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
}

class Invoice {
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

    public void printInvoice() {
        System.out.println(quantity + "x " + book.getName() + " " + book.getPrice() + "$");
        System.out.println("Discount Rate: " + discount);
        System.out.println("Tax Rate: " + tax);
        System.out.println("Total: " + calculateTotal());
    }

    public void saveToDatabase() {
        // Database-saving logic here
        System.out.println("Invoice saved to the database.");
    }
}

public class Main {
    public static void main(String[] args) {
        Book book = new Book("The Java Programming Language", "James Gosling", 2022, 49.99);
        Invoice invoice = new Invoice(book, 2, 0.1, 0.05);

        invoice.printInvoice();
        invoice.saveToDatabase();
    }
}


*/