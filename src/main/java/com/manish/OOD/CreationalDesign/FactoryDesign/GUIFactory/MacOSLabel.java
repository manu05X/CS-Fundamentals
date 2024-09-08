package com.manish.OOD.CreationalDesign.FactoryDesign.GUIFactory;

// Concrete Product for macOS Label
public class MacOSLabel implements Label {
    public void paint() {
        System.out.println("Painting a macOS label.");
    }
}
