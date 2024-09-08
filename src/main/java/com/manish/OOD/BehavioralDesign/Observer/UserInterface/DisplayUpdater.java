package com.manish.OOD.BehavioralDesign.Observer.UserInterface;

public class DisplayUpdater implements ChangeListener {
    public void onChange(boolean checked) {
        System.out.println("Checkbox is now " + (checked ? "checked" : "unchecked"));
    }
}
