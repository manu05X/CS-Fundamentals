package com.manish.CoreJava.StructuralPatterns.FacadePatternExample;

class ShapeMaker {
    private Shape3 circle = new Circle3();
    private Shape3 rectangle = new Rectangle3();
    private Shape3 square = new Square();

    public ShapeMaker() {
    }

    public void drawCircle() {
        this.circle.draw();
    }

    public void drawRectangle() {
        this.rectangle.draw();
    }

    public void drawSquare() {
        this.square.draw();
    }
}