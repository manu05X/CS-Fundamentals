package com.manish.OOP.OOD.SOLID.OpenClose.V0;

public class Main {
    public static void main(String[] args) {
        // Create boxes
        Box box1 = new Box(3.0, 4.0, 5.0);
        Box box2 = new Box(2.0, 3.0, 4.0);

        // Create a box volume calculator
        BoxVolumeCalculator volumeCalculator = new BoxVolumeCalculator();

        // Add boxes to the calculator
        volumeCalculator.addBox(box1);
        volumeCalculator.addBox(box2);

        // Calculate the total volume of all boxes
        double totalVolume = volumeCalculator.calculateTotalVolume();

        // Print the result
        System.out.println("Total Volume of Boxes: " + totalVolume);
    }
}
/*
In this example:

        The Box class represents a single box with dimensions length, width, and height. It has a method calculateVolume() to compute the volume.

        The BoxVolumeCalculator class maintains a list of boxes and provides methods to add boxes (addBox()) and calculate the total volume of all boxes (calculateTotalVolume()).

        In the com.manish.OOD.CreationalDesign.BuilderDesign.Pizza.Main class, we create instances of the Box class, add them to the BoxVolumeCalculator, and then calculate the total volume.

        This design allows you to easily extend the system by adding more boxes without modifying the existing classes, adhering to the Open/Closed Principle.

*/
