package com.manish.OOD.CreationalDesign.FactoryDesign.AbstractFactory.GUIFactory;

// Concrete Product for Linux Label
public class LinuxLabel implements Label {
    public void paint() {
        System.out.println("Painting a Linux label.");
    }
}
