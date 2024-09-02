package com.manish.OOP.OOD.SOLID.OpenClose.V2;

import java.util.ArrayList;
import java.util.List;

public class VolumeCalculator {
    private List<Shape> shapes;

    public VolumeCalculator() {
        this.shapes = new ArrayList<>();
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public double sumVolume() {
        double totalVolume = 0.0;
        for (Shape shape : shapes) {
            totalVolume += shape.calculateVolume();
        }
        return totalVolume;
    }
}