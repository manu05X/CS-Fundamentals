package com.manish.Collections.Maps;

import java.io.PrintStream;
import java.util.IdentityHashMap;
import java.util.Iterator;

public class IdentityHashMapExample {
    public IdentityHashMapExample() {
    }

    public static void main(String[] args) {
        IdentityHashMap<Integer, String> map = new IdentityHashMap();
        Integer key1 = new Integer(1);
        Integer key2 = new Integer(1);
        map.put(key1, "One");
        map.put(key2, "One");
        System.out.println("IdentityHashMap: " + String.valueOf(map));
        PrintStream var10000 = System.out;
        Object var10001 = map.get(key1);
        var10000.println("Value for key1: " + (String)var10001);
        var10000 = System.out;
        var10001 = map.get(key2);
        var10000.println("Value for key2: " + (String)var10001);
        System.out.println("Iterating through the map:");
        Iterator var4 = map.keySet().iterator();

        while(var4.hasNext()) {
            Integer key = (Integer)var4.next();
            System.out.println("Key: " + key + ", Value: " + (String)map.get(key));
        }

        map.remove(key1);
        System.out.println("IdentityHashMap after removal: " + String.valueOf(map));
    }
}
