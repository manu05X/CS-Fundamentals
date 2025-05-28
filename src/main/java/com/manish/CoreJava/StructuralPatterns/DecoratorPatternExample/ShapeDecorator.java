package com.manish.CoreJava.StructuralPatterns.DecoratorPatternExample;

abstract class ShapeDecorator implements Shape2 {
    protected Shape2 decoratedShape;

    public ShapeDecorator(Shape2 decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    public void draw() {
        this.decoratedShape.draw();
    }
}