package com.manish.OOP.OOD.SOLID.OpenClose.V2;

public class Main {
    public static void main(String[] args) {
        // Create shapes
        Cuboid cuboid = new Cuboid(3.0, 4.0, 5.0);
        Cylinder cylinder = new Cylinder(2.0, 4.0);
        Cone cone = new Cone(2.0, 4.0);

        // Create a volume calculator
        VolumeCalculator volumeCalculator = new VolumeCalculator();

        // Add shapes to the calculator
        volumeCalculator.addShape(cuboid);
        volumeCalculator.addShape(cylinder);
        volumeCalculator.addShape(cone);

        // Calculate the total volume of all shapes
        double totalVolume = volumeCalculator.sumVolume();

        // Print the result
        System.out.println("Total Volume of Shapes: " + totalVolume);
    }
}
/*
In this example:

The Cone class represents a cone with dimensions radius and height. It has a calculateVolume() method to compute the volume.

The BoxVolumeCalculator class is modified to handle a list of objects (shapes) where each shape can be either a Box or a Cone. The calculateTotalVolume() method checks the type of each shape and calculates its volume accordingly.

The com.manish.OOD.CreationalDesign.BuilderDesign.Pizza.Main class demonstrates creating instances of both Box and Cone, adding them to the calculator, and calculating the total volume.

This design allows you to easily add more shapes in the future without modifying the existing classes. It adheres to the Open/Closed Principle, allowing the system to be open for extension and closed for modification.
* */
