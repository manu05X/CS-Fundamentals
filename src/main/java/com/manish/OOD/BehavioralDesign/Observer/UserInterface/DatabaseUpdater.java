package com.manish.OOD.BehavioralDesign.Observer.UserInterface;

public class DatabaseUpdater implements ChangeListener {
    public void onChange(boolean checked) {
        System.out.println("Updating database with checkbox state...");
    }
}
