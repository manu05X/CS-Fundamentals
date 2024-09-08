package com.manish.OOD.CreationalDesign.Singleton.Cache;

public class Main {
    public static void main(String[] args) {
        Cache cache = Cache.getInstance();

        // Put values in the cache
        cache.put("key1", "value1");
        cache.put("key2", 42);

        // Get values from the cache
        String value1 = (String) cache.get("key1");
        int value2 = (int) cache.get("key2");

        System.out.println("Value 1: " + value1);
        System.out.println("Value 2: " + value2);

        // Remove a key-value pair
        cache.remove("key1");

        // Clear the entire cache
        cache.clear();

        // Get the size of the cache
        int cacheSize = cache.size();
        System.out.println("Cache size: " + cacheSize);
    }
}
