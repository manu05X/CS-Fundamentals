package com.manish.CoreJava.StructuralPatterns.DecoratorPatternExample;

public class DecoratorPatternExample {
    public DecoratorPatternExample() {
    }

    public static void main(String[] args) {
        Shape2 circle = new Circle2();
        Shape2 redCircle = new RedShapeDecorator2(new Circle2());
        Shape2 redRectangle = new RedShapeDecorator2(new Rectangle());
        System.out.println("Circle with normal border");
        circle.draw();
        System.out.println("\nCircle with red border");
        redCircle.draw();
        System.out.println("\nRectangle with red border");
        redRectangle.draw();
    }
}