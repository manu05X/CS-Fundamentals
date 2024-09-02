package com.manish.OOP.OOD.SOLID.OpenClose.V1;

import java.util.ArrayList;
import java.util.List;

class BoxVolumeCalculator {
    private List<Object> shapes; // Using Object for simplicity, you might use a common interface.

    public BoxVolumeCalculator() {
        this.shapes = new ArrayList<>();
    }

    public void addShape(Object shape) {
        shapes.add(shape);
    }

    public double calculateTotalVolume() {
        double totalVolume = 0.0;
        for (Object shape : shapes) {
            if (shape instanceof Box) {
                totalVolume += ((Box) shape).calculateVolume();
            } else if (shape instanceof Cone) {
                totalVolume += ((Cone) shape).calculateVolume();
            }
            // Add other shape types as needed
        }
        return totalVolume;
    }
}