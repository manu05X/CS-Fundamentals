package com.manish.Collections.Arraylist.B_Operations;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo3 {

    public static void main(String args[]) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(10);

        list.set(1, 100);

        System.out.println(list); //[10, 100, 30, 40, 10]

        if (list.contains(30)) {
            System.out.println("List contains 30");
        }

        System.out.println("Index of first occurence of 10 is " + list.indexOf(10));
        System.out.println("Index of last occurence of 10 is " + list.lastIndexOf(10));
    }
}

/*
[10, 100, 30, 40, 10]
List contains 30
Index of first occurence of 10 is 0
Index of last occurence of 10 is 4
 */