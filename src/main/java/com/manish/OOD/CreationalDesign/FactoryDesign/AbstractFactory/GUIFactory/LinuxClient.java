package com.manish.OOD.CreationalDesign.FactoryDesign.AbstractFactory.GUIFactory;

// Sample client code that creates an Application for Linux
public class LinuxClient {
    public static void main(String[] args) {
        GUIFactory factory = new LinuxGUIFactory();
        Application app = new Application(factory);
        app.paint();
    }
}
