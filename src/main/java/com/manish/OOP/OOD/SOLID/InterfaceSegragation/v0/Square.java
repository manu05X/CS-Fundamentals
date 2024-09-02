package com.manish.OOP.OOD.SOLID.InterfaceSegragation.v0;

public class Square implements Shape{
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double area() {
        return side * side;
    }
}
