package com.manish.OOD.CreationalDesign.FactoryDesign.GUIFactory;

// Concrete Product for macOS Button
public class MacOSButton implements Button {
    public void paint() {
        System.out.println("Painting a macOS button.");
    }
}
