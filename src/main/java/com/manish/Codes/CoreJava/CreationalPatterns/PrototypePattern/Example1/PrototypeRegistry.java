package com.manish.Codes.CoreJava.CreationalPatterns.PrototypePattern.Example1;

import java.util.HashMap;
import java.util.Map;

// Prototype registry to manage prototypes
class PrototypeRegistry {
    private Map<String, Prototype> prototypes = new HashMap<>();

    public void addPrototype(String key, Prototype prototype) {
        prototypes.put(key, prototype);
    }

    public Prototype getPrototype(String key) throws CloneNotSupportedException {
        Prototype prototype = prototypes.get(key);
        if (prototype != null) {
            return prototype.clone();
        }
        return null;
    }
}
