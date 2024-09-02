package com.manish.OOP.OOD.SOLID.InterfaceSegragation.v1;

public class Cube implements TwoDimensionalShape, ThreeDimensionalShape {
    private double side;

    public Cube(double side) {
        this.side = side;
    }

    @Override
    public double area() {
        return 6 * side * side; // Surface area of a cube
    }

    @Override
    public double volume() {
        return Math.pow(side, 3); // Volume of a cube
    }
}
