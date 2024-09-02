package com.manish.OOP.OOD.SOLID.OpenClose.V1;

public class Cone {
    private double radius;
    private double height;

    public Cone(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    public double calculateVolume() {
        return (1.0 / 3.0) * Math.PI * Math.pow(radius, 2) * height;
    }
}