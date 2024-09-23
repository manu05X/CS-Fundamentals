package com.manish.Codes.CoreJava.CreationalPatterns.FactoryPattern.Example1;

// Factory class
class ShapeFactory {
    // Method to get an object of type Shape
    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        }
        return null;
    }
}
