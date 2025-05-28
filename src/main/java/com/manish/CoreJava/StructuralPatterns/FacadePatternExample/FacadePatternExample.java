package com.manish.CoreJava.StructuralPatterns.FacadePatternExample;

public class FacadePatternExample {
    public FacadePatternExample() {
    }

    public static void main(String[] args) {
        ShapeMaker shapeMaker = new ShapeMaker();
        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();
    }
}
