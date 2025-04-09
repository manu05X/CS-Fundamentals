package com.manish.Generics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WildcardExample {
    public WildcardExample() {
    }

    public static void printList(List<?> list) {
        Iterator var1 = list.iterator();

        while(var1.hasNext()) {
            Object element = var1.next();
            System.out.print(String.valueOf(element) + " ");
        }

        System.out.println();
    }

    public static double sumList(List<? extends Number> list) {
        double sum = 0.0;

        Number number;
        for(Iterator var3 = list.iterator(); var3.hasNext(); sum += number.doubleValue()) {
            number = (Number)var3.next();
        }

        return sum;
    }

    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        System.out.print("Integer List: ");
        printList(integerList);
        List<Double> doubleList = new ArrayList();
        doubleList.add(1.1);
        doubleList.add(2.2);
        doubleList.add(3.3);
        System.out.print("Double List: ");
        printList(doubleList);
        System.out.println("Sum of Integer List: " + sumList(integerList));
        System.out.println("Sum of Double List: " + sumList(doubleList));
    }
}