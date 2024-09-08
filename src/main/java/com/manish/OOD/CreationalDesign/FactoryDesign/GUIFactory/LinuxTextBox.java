package com.manish.OOD.CreationalDesign.FactoryDesign.GUIFactory;

// Concrete Product for Linux TextBox
public class LinuxTextBox implements TextBox {
    public void paint() {
        System.out.println("Painting a Linux text box.");
    }
}
