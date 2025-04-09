package com.manish.Collections.Maps;

import java.util.WeakHashMap;

public class WeakHashMapExample {
    public WeakHashMapExample() {
    }

    public static void main(String[] args) {
        WeakHashMap<String, Integer> map = new WeakHashMap();
        String key1 = new String("Apple");
        String key2 = new String("Banana");
        map.put(key1, 1);
        map.put(key2, 2);
        System.out.println("WeakHashMap: " + String.valueOf(map));
        System.out.println("Value for key 'Apple': " + String.valueOf(map.get("Apple")));
        key1 = null;
        key2 = null;
        System.gc();

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException var5) {
            InterruptedException e = var5;
            e.printStackTrace();
        }

        System.out.println("WeakHashMap after GC: " + String.valueOf(map));
    }
}
