package com.manish.Codes.CoreJava.CreationalPatterns.PrototypePattern.Example1;

// Concrete prototype class
class Circle1 implements Prototype {
    private int radius;

    public Circle1(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public Circle1 clone() throws CloneNotSupportedException {
        return (Circle1) super.clone();
    }
}
