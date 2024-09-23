package com.manish.Codes.CoreJava.CreationalPatterns.FactoryPattern.Example1;

// com.manish.OOD.CreationalDesign.BuilderDesign.Pizza.Main class to test the Factory pattern
public class FactoryPatternExample {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        // Get an object of Circle and call its draw method
        Shape shape1 = shapeFactory.getShape("CIRCLE");
        shape1.draw(); // Output: Drawing Circle

        // Get an object of Rectangle and call its draw method
        Shape shape2 = shapeFactory.getShape("RECTANGLE");
        shape2.draw(); // Output: Drawing Rectangle
    }
}
