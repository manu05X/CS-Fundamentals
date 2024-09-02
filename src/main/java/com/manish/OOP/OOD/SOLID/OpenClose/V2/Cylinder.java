package com.manish.OOP.OOD.SOLID.OpenClose.V2;

public class Cylinder extends Shape {
    private double radius;
    private double height;

    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    @Override
    double calculateVolume() {
        return Math.PI * radius * radius * height;
    }
}