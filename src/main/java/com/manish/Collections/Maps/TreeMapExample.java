package com.manish.Collections.Maps;

import java.util.Iterator;
import java.util.TreeMap;

public class TreeMapExample {
    public TreeMapExample() {
    }

    public static void main(String[] args) {
        TreeMap<String, Integer> map = new TreeMap();
        map.put("Apple", 1);
        map.put("Banana", 2);
        map.put("Cherry", 3);
        System.out.println("TreeMap: " + String.valueOf(map));
        System.out.println("Value for key 'Banana': " + String.valueOf(map.get("Banana")));
        System.out.println("Iterating through the map:");
        Iterator var2 = map.keySet().iterator();

        while(var2.hasNext()) {
            String key = (String)var2.next();
            System.out.println("Key: " + key + ", Value: " + String.valueOf(map.get(key)));
        }

        map.remove("Cherry");
        System.out.println("TreeMap after removal: " + String.valueOf(map));
    }
}
