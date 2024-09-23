package com.manish.OOD.CreationalDesign.Singleton.Cache;

import java.util.HashMap;
import java.util.Map;

public class Cache {
    private static volatile Cache instance;
    private Map<String, Object> cache;

    // Private constructor to prevent instantiation
    private Cache() {
        // Initialize cache
        cache = new HashMap<>();
    }

    // Singleton instance retrieval
    public static Cache getInstance() {
        if (instance == null) {
            synchronized (Cache.class) {
                if (instance == null) {
                    instance = new Cache();
                }
            }
        }
        return instance;
    }

    // Method to put a key-value pair in the cache
    public void put(String key, Object value) {
        cache.put(key, value);
    }

    // Method to get a value from the cache by key
    public Object get(String key) {
        return cache.get(key);
    }

    // Method to remove a key-value pair from the cache
    public void remove(String key) {
        cache.remove(key);
    }

    // Method to clear the entire cache
    public void clear() {
        cache.clear();
    }

    // Method to get the size of the cache
    public int size() {
        return cache.size();
    }
}

/*
public class com.manish.OOD.CreationalDesign.BuilderDesign.Pizza.Main {
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
 */
