package com.manish.OOD.CreationalDesign.FactoryDesign.AbstractFactory.GUIFactory;

// Sample client code that creates an Application for Windows
public class WindowsClient {
    public static void main(String[] args) {
        GUIFactory factory = new WindowsGUIFactory();
        Application app = new Application(factory);
        app.paint();
    }
}
