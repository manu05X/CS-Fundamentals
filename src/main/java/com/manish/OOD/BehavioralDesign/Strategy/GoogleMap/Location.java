package com.manish.OOD.BehavioralDesign.Strategy.GoogleMap;

public class Location {
    private String name;

    public Location(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
