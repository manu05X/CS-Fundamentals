package com.manish.OOD.StructuralDesign.AdapterPattern.Shape;

// Client Code
public class Client {
    public static void main(String[] args) {
        // Create an instance of Rectangle (Adaptee)
        Rectangle rectangle = new Rectangle();

        // Create an adapter to adapt Rectangle to Square interface
        Square squareAdapter = new RectangleAdapter(rectangle);

        // Call draw method on the Square interface
        squareAdapter.draw();
    }
}
