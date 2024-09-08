package com.manish.OOD.CreationalDesign.FactoryDesign.AbstractFactory.GUIFactory;

// Abstract Factory interface for creating GUI components
public interface GUIFactory {
    public Button createButton();
    public TextBox createTextBox();
    public Label createLabel();
}

