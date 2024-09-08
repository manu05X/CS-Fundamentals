package com.manish.OOD.StructuralDesign.Flyweight.Example1;

// Client class to test the Flyweight pattern
public class Main {
    public static void main(String[] args) {
        // Get flyweight objects from the factory
        Flyweight flyweight1 = FlyweightFactory.getFlyweight("key1");
        flyweight1.operation();

        Flyweight flyweight2 = FlyweightFactory.getFlyweight("key2");
        flyweight2.operation();

        // This should reuse the existing Flyweight with key "key1"
        Flyweight flyweight3 = FlyweightFactory.getFlyweight("key1");
        flyweight3.operation();
    }
}

