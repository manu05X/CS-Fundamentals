package com.manish.CoreJava.StructuralPatterns.BridgePatternExample;

class GreenCircle implements DrawAPI {
    GreenCircle() {
    }

    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: green, radius: " + radius + ", x: " + x + ", y: " + y + "]");
    }
}