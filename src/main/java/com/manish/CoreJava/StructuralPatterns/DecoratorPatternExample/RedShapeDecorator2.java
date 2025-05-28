package com.manish.CoreJava.StructuralPatterns.DecoratorPatternExample;

class RedShapeDecorator2 extends ShapeDecorator {
    public RedShapeDecorator2(Shape2 decoratedShape) {
        super(decoratedShape);
    }

    public void draw() {
        this.decoratedShape.draw();
        this.setRedBorder(this.decoratedShape);
    }

    private void setRedBorder(Shape2 decoratedShape) {
        System.out.println("Border Color: Red");
    }
}