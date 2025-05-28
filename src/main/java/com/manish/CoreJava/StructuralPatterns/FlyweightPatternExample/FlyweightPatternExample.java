package com.manish.CoreJava.StructuralPatterns.FlyweightPatternExample;


public class FlyweightPatternExample {
    private static final String[] colors = new String[]{"Red", "Green", "Blue", "White", "Black"};

    public FlyweightPatternExample() {
    }

    public static void main(String[] args) {
        for(int i = 0; i < 20; ++i) {
            Circle4 circle = (Circle4) ShapeFactory.getCircle(getRandomColor());
            circle.setX(getRandomX());
            circle.setY(getRandomY());
            circle.setRadius(100);
            circle.draw();
        }

    }

    private static String getRandomColor() {
        return colors[(int)(Math.random() * (double)colors.length)];
    }

    private static int getRandomX() {
        return (int)(Math.random() * 100.0);
    }

    private static int getRandomY() {
        return (int)(Math.random() * 100.0);
    }
}