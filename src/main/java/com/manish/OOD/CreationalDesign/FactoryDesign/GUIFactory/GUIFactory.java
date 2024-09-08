package com.manish.OOD.CreationalDesign.FactoryDesign.GUIFactory;

// Abstract Factory interface for creating GUI components
public interface GUIFactory {
    public Button createButton();
    public TextBox createTextBox();
    public Label createLabel();
}

