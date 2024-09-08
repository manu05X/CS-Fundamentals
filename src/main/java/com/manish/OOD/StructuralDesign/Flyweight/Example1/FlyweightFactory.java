package com.manish.OOD.StructuralDesign.Flyweight.Example1;

import java.util.HashMap;
import java.util.Map;

// FlyweightFactory class manages and provides Flyweight objects
public class FlyweightFactory {
    private static final Map<String, Flyweight> flyweights = new HashMap<>();

    public static Flyweight getFlyweight(String key) {
        Flyweight flyweight = flyweights.get(key);
        if (flyweight == null) {
            flyweight = new ConcreteFlyweight(key);
            flyweights.put(key, flyweight);
            System.out.println("Creating new ConcreteFlyweight with key: " + key);
        } else {
            System.out.println("Reusing existing ConcreteFlyweight with key: " + key);
        }
        return flyweight;
    }
}
