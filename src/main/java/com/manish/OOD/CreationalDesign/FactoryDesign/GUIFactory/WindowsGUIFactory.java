package com.manish.OOD.CreationalDesign.FactoryDesign.GUIFactory;

// Concrete factory for creating GUI components for Windows platform
public class WindowsGUIFactory implements GUIFactory {
    public Button createButton() {
        return new WindowsButton();
    }

    public TextBox createTextBox() {
        return new WindowsTextBox();
    }

    public Label createLabel() {
        return new WindowsLabel();
    }
}
