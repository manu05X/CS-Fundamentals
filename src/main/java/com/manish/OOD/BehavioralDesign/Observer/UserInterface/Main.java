package com.manish.OOD.BehavioralDesign.Observer.UserInterface;

public class Main {
    public static void main(String[] args) {
        Checkbox checkbox = new Checkbox();
        checkbox.addChangeListener(new DisplayUpdater());
        checkbox.addChangeListener(new DatabaseUpdater());
        checkbox.setChecked(true);
    }
}
