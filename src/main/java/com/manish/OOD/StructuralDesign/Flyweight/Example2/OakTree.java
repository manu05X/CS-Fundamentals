package com.manish.OOD.StructuralDesign.Flyweight.Example2;

import java.awt.*;

// Concrete tree implementation
public class OakTree implements Tree {
    private int x;
    private int y;
    private Image image;

    public OakTree(Image image) {
        this.image = image;
    }

    @Override
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(image, x, y, null);
    }
}
