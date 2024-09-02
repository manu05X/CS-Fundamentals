package com.manish.OOP.OOD.SOLID.InterfaceSegragation.v1;

public class Runner {
    public static void main(String[] args) {
        // Create instances of TwoDimensionalShape and ThreeDimensionalShape
        TwoDimensionalShape square = new Square(5.0);
        TwoDimensionalShape rectangle = new Rectangle(4.0, 6.0);
        ThreeDimensionalShape cube = new Cube(3.0);

        // Calculate and print the area and volume of each shape
        System.out.println("Area of Square: " + square.area());

        System.out.println("Area of Rectangle: " + rectangle.area());

        System.out.println("Area of Cube: " + ((TwoDimensionalShape) cube).area()); // Casting to TwoDimensionalShape
        System.out.println("Volume of Cube: " + cube.volume());
    }
}
