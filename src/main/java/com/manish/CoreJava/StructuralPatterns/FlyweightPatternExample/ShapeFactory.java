package com.manish.CoreJava.StructuralPatterns.FlyweightPatternExample;


import java.util.HashMap;

class ShapeFactory {
    private static final HashMap<String, Shape4> circleMap = new HashMap();

    ShapeFactory() {
    }

    public static Shape4 getCircle(String color) {
        Circle4 circle = (Circle4)circleMap.get(color);
        if (circle == null) {
            circle = new Circle4(color);
            circleMap.put(color, circle);
            System.out.println("Creating circle of color : " + color);
        }

        return circle;
    }
}