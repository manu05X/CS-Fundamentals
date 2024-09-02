package com.manish.OOP.OOD.SOLID.OpenClose.V2;

public class Cone extends Shape {
    private double radius;
    private double height;

    public Cone(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    @Override
    double calculateVolume() {
        return (1.0 / 3.0) * Math.PI * radius * radius * height;
    }
}