package com.manish.CoreJava.StructuralPatterns.BridgePatternExample;


public class BridgePatternExample {
    public BridgePatternExample() {
    }

    public static void main(String[] args) {
        Shape redCircle = new Circle(100, 100, 10, new RedCircle());
        Shape greenCircle = new Circle(100, 100, 10, new GreenCircle());
        ((Shape)redCircle).draw();
        ((Shape)greenCircle).draw();
    }
}