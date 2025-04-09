package com.manish.Collections.HashTables;

import java.io.PrintStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashtableExample {
    public HashtableExample() {
    }

    public static void main(String[] args) {
        Hashtable<String, Integer> hashtable = new Hashtable();
        hashtable.put("One", 1);
        hashtable.put("Two", 2);
        hashtable.put("Three", 3);
        hashtable.put("Four", 4);
        Integer value = (Integer)hashtable.get("Two");
        System.out.println("Value associated with key 'Two': " + value);
        hashtable.remove("Three");
        System.out.println("\nIterating over keys using Enumeration:");
        Enumeration<String> keys = hashtable.keys();

        while(keys.hasMoreElements()) {
            String key = (String)keys.nextElement();
            System.out.println("Key: " + key + ", Value: " + String.valueOf(hashtable.get(key)));
        }

        System.out.println("\nIterating over entries using Entry Set and Iterator:");
        Set<Map.Entry<String, Integer>> entrySet = hashtable.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entrySet.iterator();

        while(iterator.hasNext()) {
            Map.Entry<String, Integer> entry = (Map.Entry)iterator.next();
            PrintStream var10000 = System.out;
            String var10001 = (String)entry.getKey();
            var10000.println("Key: " + var10001 + ", Value: " + String.valueOf(entry.getValue()));
        }

    }
}
