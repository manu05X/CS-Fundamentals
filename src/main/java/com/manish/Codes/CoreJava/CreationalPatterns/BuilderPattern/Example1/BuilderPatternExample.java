package com.manish.Codes.CoreJava.CreationalPatterns.BuilderPattern.Example1;

// com.manish.OOD.CreationalDesign.BuilderDesign.Pizza.Main class to test the Builder pattern
public class BuilderPatternExample {
    public static void main(String[] args) {
        // Create a Computer object using the Builder
        Computer computer = new Computer.ComputerBuilder("500 GB", "8 GB")
                .setGraphicsCardEnabled(true)
                .setBluetoothEnabled(true)
                .build();

        // Print the specifications of the computer
        System.out.println("HDD: " + computer.getHDD()); // Output HDD: 500 GB
        System.out.println("RAM: " + computer.getRAM()); // Output: RAM: 8 GB
        System.out.println("Graphics Card Enabled: " + computer.isGraphicsCardEnabled()); // Output: Graphics Card Enabled: true
        System.out.println("Bluetooth Enabled: " + computer.isBluetoothEnabled()); // Output Bluetooth Enabled: true
    }
}
