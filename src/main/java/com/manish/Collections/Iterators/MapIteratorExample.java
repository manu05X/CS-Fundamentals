package com.manish.Collections.Iterators;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapIteratorExample {
    public MapIteratorExample() {
    }

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");
        Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
        Iterator<Map.Entry<Integer, String>> iterator = entrySet.iterator();
        System.out.println("Traversing the map:");

        while(iterator.hasNext()) {
            Map.Entry<Integer, String> entry = (Map.Entry)iterator.next();
            PrintStream var10000 = System.out;
            String var10001 = String.valueOf(entry.getKey());
            var10000.println("Key: " + var10001 + ", Value: " + (String)entry.getValue());
        }

    }
}
