package com.manish.Collections.Arraylist.B_Operations;

import java.util.ArrayList;
import java.util.List;


public class ArrayListDemo1 {

    public static void main(String args[]) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.add(60);
        list.add(70);
        list.add(80);

        System.out.println(list); //[10, 20, 30, 40, 50, 60, 70, 80]

        list.remove(1);  // This will remove the element at index 1 i.e 20. [10, 30, 40, 50, 60, 70, 80]
        System.out.println(list);

        list.remove(new Integer(30)); // This will remove 30 from the list. [10, 40, 50, 60, 70, 80]
        System.out.println(list);

        list.clear(); //This will remove all the elements from the list.
        System.out.println(list);
    }
}
/*
OUTPUT:
[10, 20, 30, 40, 50, 60, 70, 80]
[10, 30, 40, 50, 60, 70, 80]
[10, 40, 50, 60, 70, 80]
[]
 */