package com.manish.OOD.BehavioralDesign.Observer.EventHandling;

public class Main {
    public static void main(String[] args) {
        Button button = new Button();
        button.addClickListener(new DisplayUpdater());
        button.addClickListener(new Calculator());
        button.click();
    }
}
