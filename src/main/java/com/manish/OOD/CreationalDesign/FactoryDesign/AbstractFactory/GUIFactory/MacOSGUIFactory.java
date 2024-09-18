package com.manish.OOD.CreationalDesign.FactoryDesign.AbstractFactory.GUIFactory;

// Concrete factory for creating GUI components for macOS platform
public class MacOSGUIFactory implements GUIFactory {
    public Button createButton() {
        return new MacOSButton();
    }

    public TextBox createTextBox() {
        return new MacOSTextBox();
    }

    public Label createLabel() {
        return new MacOSLabel();
    }
}
