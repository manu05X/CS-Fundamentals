package com.manish.Collections.Maps;

import java.util.Iterator;
import java.util.NavigableMap;
import java.util.TreeMap;

public class NavigableMapExample {
    public NavigableMapExample() {
    }

    public static void main(String[] args) {
        NavigableMap<String, Integer> map = new TreeMap();
        map.put("Apple", 1);
        map.put("Banana", 2);
        map.put("Cherry", 3);
        map.put("Date", 4);
        System.out.println("NavigableMap: " + String.valueOf(map));
        System.out.println("First entry: " + String.valueOf(map.firstEntry()));
        System.out.println("Last entry: " + String.valueOf(map.lastEntry()));
        System.out.println("Lower than 'Banana': " + String.valueOf(map.lowerEntry("Banana")));
        System.out.println("Higher than 'Banana': " + String.valueOf(map.higherEntry("Banana")));
        System.out.println("Iterating through the map:");
        Iterator var2 = map.keySet().iterator();

        while(var2.hasNext()) {
            String key = (String)var2.next();
            System.out.println("Key: " + key + ", Value: " + String.valueOf(map.get(key)));
        }

        map.remove("Date");
        System.out.println("NavigableMap after removal: " + String.valueOf(map));
    }
}
