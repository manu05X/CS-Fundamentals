package com.manish.Collections.Maps;

import java.util.Iterator;
import java.util.LinkedHashMap;

public class LinkedHashMapExample {
    public LinkedHashMapExample() {
    }

    public static void main(String[] args) {
        LinkedHashMap<Integer, String> map = new LinkedHashMap();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        System.out.println("LinkedHashMap: " + String.valueOf(map));
        System.out.println("Value for key 2: " + (String)map.get(2));
        System.out.println("Iterating through the map:");
        Iterator var2 = map.keySet().iterator();

        while(var2.hasNext()) {
            Integer key = (Integer)var2.next();
            System.out.println("Key: " + key + ", Value: " + (String)map.get(key));
        }

        map.remove(3);
        System.out.println("LinkedHashMap after removal: " + String.valueOf(map));
    }
}
