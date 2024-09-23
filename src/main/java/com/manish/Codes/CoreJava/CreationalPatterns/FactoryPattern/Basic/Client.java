package com.manish.Codes.CoreJava.CreationalPatterns.FactoryPattern.Basic;

// Client Code
public class Client {
    public static void main(String[] args) {
        Application app;

        // Depending on the type, create the appropriate application
        String type = "text"; // This could be determined at runtime
        if (type.equals("text")) {
            app = new TextApplication();
        } else {
            app = new SpreadsheetApplication();
        }

        // Use the factory method to create a document
        app.newDocument(); //  Output: Opening text document...
    }
}

/*
What is the Factory Method pattern, and when would you use it?
The Factory Method pattern is a creational design pattern that provides an interface for creating objects in a superclass but allows subclasses to alter the type of objects that will be created. Instead of calling a constructor directly to create an object, the Factory Method pattern relies on a separate method to create instances, which can be overridden by subclasses to change the class of objects that are instantiated.

Key Concepts
Creator Class: This class declares the factory method, which returns objects of a Product class.
Concrete Creator Class: Subclasses that override the factory method to change the class of objects that will be created.
Product Interface: An interface or abstract class that defines the type of object the factory method will return.
Concrete Product Class: Concrete implementations of the Product interface.
 */