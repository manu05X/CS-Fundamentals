package com.manish.Collections.Maps;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapIteratorExample {
    public MapIteratorExample() {
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap();
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        System.out.println("Iterating through the map:");

        Map.Entry entry;
        while(iterator.hasNext()) {
            entry = (Map.Entry)iterator.next();
            PrintStream var10000 = System.out;
            String var10001 = (String)entry.getKey();
            var10000.println("Key: " + var10001 + ", Value: " + String.valueOf(entry.getValue()));
        }

        iterator = map.entrySet().iterator();

        while(iterator.hasNext()) {
            entry = (Map.Entry)iterator.next();
            if (((String)entry.getKey()).equals("Two")) {
                iterator.remove();
            }
        }

        System.out.println("Map after removal: " + String.valueOf(map));
    }
}
