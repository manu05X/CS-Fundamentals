package com.manish.Thread.concurrency.ThreadSafety;

import java.util.concurrent.ConcurrentHashMap;

public class SharedResourceExample {
    private ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

    public void put(String key, int value){
        map.put(key, value);
    }

    public int get(String key){
        return map.getOrDefault(key,0);
    }
}
