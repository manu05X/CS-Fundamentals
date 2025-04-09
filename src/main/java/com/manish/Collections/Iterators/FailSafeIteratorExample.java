package com.manish.Collections.Iterators;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailSafeIteratorExample {
    public FailSafeIteratorExample() {
    }

    public static void main(String[] args) {
        List<String> failSafeList = new CopyOnWriteArrayList();
        failSafeList.add("Element1");
        failSafeList.add("Element2");
        failSafeList.add("Element3");
        Iterator<String> iterator = failSafeList.iterator();

        while(iterator.hasNext()) {
            String element = (String)iterator.next();
            System.out.println("Current Element: " + element);
            failSafeList.add("NewElement");
        }

        System.out.println("\nFinal list after modification:");
        Iterator var5 = failSafeList.iterator();

        while(var5.hasNext()) {
            String element = (String)var5.next();
            System.out.println(element);
        }

    }
}
