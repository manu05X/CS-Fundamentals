package com.manish.OOP.OOD.SOLID.InterfaceSegragation.v0;

public class Rectangle implements Shape{
    private double length;
    private double width;

    public Rectangle(double length, double width){
        this.length = length;
        this.width = width;
    }
    @Override
    public double area(){
        return length*width;
    }
}
