package com.manish.OOP.OOD.SOLID.OpenClose.V2;

public class Cuboid extends Shape {
    private double length;
    private double width;
    private double height;

    public Cuboid(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    double calculateVolume() {
        return length * width * height;
    }
}


