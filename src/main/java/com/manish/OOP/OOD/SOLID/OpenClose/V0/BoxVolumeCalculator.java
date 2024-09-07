package com.manish.OOP.OOD.SOLID.OpenClose.V0;

import com.manish.OOP.OOD.SOLID.OpenClose.V1.Cone;

import java.util.ArrayList;
import java.util.List;

public class BoxVolumeCalculator {
    private List<Box> boxes;

    public BoxVolumeCalculator() {
        this.boxes = new ArrayList<>();
    }

    public void addBox(Box box) {
        boxes.add(box);
    }

    public double calculateTotalVolume() {
        double totalVolume = 0.0;
        for (Box box : boxes) {
            totalVolume += box.calculateVolume();
        }
        return totalVolume;
    }

    public void addShape(Cone box2) {
    }
}
