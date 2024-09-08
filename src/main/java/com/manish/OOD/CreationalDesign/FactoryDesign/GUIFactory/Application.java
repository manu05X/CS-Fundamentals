package com.manish.OOD.CreationalDesign.FactoryDesign.GUIFactory;

// Client code that uses the abstract factory to create related objects
public class Application {
    private Button button;
    private TextBox textBox;
    private Label label;

    public Application(GUIFactory factory) {
        button = factory.createButton();
        textBox = factory.createTextBox();
        label = factory.createLabel();
    }

    public void paint() {
        button.paint();
        textBox.paint();
        label.paint();
    }
}
