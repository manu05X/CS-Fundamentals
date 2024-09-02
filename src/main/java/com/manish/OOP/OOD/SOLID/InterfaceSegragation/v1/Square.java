package com.manish.OOP.OOD.SOLID.InterfaceSegragation.v1;

public class Square implements TwoDimensionalShape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double area() {
        return side * side;
    }
}