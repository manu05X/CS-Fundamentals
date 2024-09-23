package com.manish.OOP.OOD.SOLID.InterfaceSegragation.v0;

public class Runner {
    public static void main(String[] args){
        // Create instances of Square and Rectangle
        Square square = new Square(6);
        Rectangle rectangle = new Rectangle(7,4);

        // Calculate and print the area of each shape
        System.out.println("Area of Square: " + square.area());
        System.out.println("Area of Rectangle: " + rectangle.area());
    }
}

/*
In this example:

The Shape interface declares a single method area().

The Square class implements the Shape interface and provides an implementation for the area() method based on the formula for the area of a square.

The Rectangle class also implements the Shape interface and provides an implementation for the area() method based on the formula for the area of a rectangle.

In the com.manish.OOD.CreationalDesign.BuilderDesign.Pizza.Main class, we create instances of Square and Rectangle and calculate and print their respective areas.

This design allows you to easily add more shapes in the future by creating new classes that implement the Shape interface, without modifying the existing code. It adheres to the Open/Closed Principle, allowing the system to be open for extension and closed for modification.
*/