package com.manish.OOD.CreationalDesign.FactoryDesign.AbstractFactory.GUIFactory;

// Concrete Product for Windows TextBox
public class WindowsTextBox implements TextBox {
    public void paint() {
        System.out.println("Painting a Windows text box.");
    }
}
