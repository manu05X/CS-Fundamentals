package com.manish.Collections.Maps;

import java.util.HashMap;
import java.util.Iterator;

public class HashMapExample {
    public HashMapExample() {
    }

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        System.out.println("HashMap: " + String.valueOf(map));
        System.out.println("Value for key 2: " + (String)map.get(2));
        System.out.println("Iterating through the map:");
        Iterator var2 = map.keySet().iterator();

        while(var2.hasNext()) {
            Integer key = (Integer)var2.next();
            System.out.println("Key: " + key + ", Value: " + (String)map.get(key));
        }

        map.remove(3);
        System.out.println("HashMap after removal: " + String.valueOf(map));
    }
}
