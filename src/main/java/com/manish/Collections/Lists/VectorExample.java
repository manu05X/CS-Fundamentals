package com.manish.Collections.Lists;

import java.util.Iterator;
import java.util.Vector;

public class VectorExample {
    public VectorExample() {
    }

    public static void main(String[] args) {
        Vector<Integer> vector = new Vector();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        System.out.println("Vector elements: " + String.valueOf(vector));
        int element = (Integer)vector.get(1);
        System.out.println("Element at index 1: " + element);
        vector.remove(2);
        System.out.println("Vector after removing 2: " + String.valueOf(vector));
        System.out.print("Iterating over Vector: ");
        Iterator var3 = vector.iterator();

        while(var3.hasNext()) {
            int number = (Integer)var3.next();
            System.out.print("" + number + " ");
        }

    }
}
