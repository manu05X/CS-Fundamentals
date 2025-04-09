package com.manish.Collections.Lists;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListExample {
    public ArrayListExample() {
    }

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList();
        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Cherry");
        System.out.println("ArrayList elements: " + String.valueOf(arrayList));
        String element = (String)arrayList.get(1);
        System.out.println("Element at index 1: " + element);
        arrayList.remove("Banana");
        System.out.println("ArrayList after removing Banana: " + String.valueOf(arrayList));
        System.out.print("Iterating over ArrayList: ");
        Iterator var3 = arrayList.iterator();

        while(var3.hasNext()) {
            String fruit = (String)var3.next();
            System.out.print(fruit + " ");
        }

    }
}
