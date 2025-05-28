package com.manish.CoreJava.StructuralPatterns.BridgePatternExample;

class RedCircle implements DrawAPI {
    RedCircle() {
    }

    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: red, radius: " + radius + ", x: " + x + ", y: " + y + "]");
    }
}