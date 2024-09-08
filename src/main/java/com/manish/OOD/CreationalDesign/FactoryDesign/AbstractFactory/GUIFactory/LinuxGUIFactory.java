package com.manish.OOD.CreationalDesign.FactoryDesign.AbstractFactory.GUIFactory;

// Concrete factory for creating GUI components for Linux platform
public class LinuxGUIFactory implements GUIFactory {
    public Button createButton() {
        return new LinuxButton();
    }

    public TextBox createTextBox() {
        return new LinuxTextBox();
    }

    public Label createLabel() {
        return new LinuxLabel();
    }
}
