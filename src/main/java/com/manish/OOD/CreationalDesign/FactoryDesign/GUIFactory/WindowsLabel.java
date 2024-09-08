package com.manish.OOD.CreationalDesign.FactoryDesign.GUIFactory;

// Concrete Product for Windows Label
public class WindowsLabel implements Label {
    public void paint() {
        System.out.println("Painting a Windows label.");
    }
}
