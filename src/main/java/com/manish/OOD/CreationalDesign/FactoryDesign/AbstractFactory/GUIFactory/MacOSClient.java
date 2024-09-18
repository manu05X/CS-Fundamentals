package com.manish.OOD.CreationalDesign.FactoryDesign.AbstractFactory.GUIFactory;

// Sample client code that creates an Application for macOS
public class MacOSClient {
    public static void main(String[] args) {
        GUIFactory factory = new MacOSGUIFactory();
        Application app = new Application(factory);
        app.paint();
    }
}
