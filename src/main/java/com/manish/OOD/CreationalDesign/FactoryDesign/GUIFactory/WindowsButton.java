package com.manish.OOD.CreationalDesign.FactoryDesign.GUIFactory;

// Concrete Product for Windows Button
public class WindowsButton implements Button {
    public void paint() {
        System.out.println("Painting a Windows button.");
    }
}
