package com.manish.OOD.CreationalDesign.FactoryDesign.AbstractFactory.GUIFactory;

// Concrete Product for macOS TextBox
public class MacOSTextBox implements TextBox {
    public void paint() {
        System.out.println("Painting a macOS text box.");
    }
}