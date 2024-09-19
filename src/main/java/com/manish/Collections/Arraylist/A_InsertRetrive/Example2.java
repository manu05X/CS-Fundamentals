package com.manish.Collections.Arraylist.A_InsertRetrive;

import java.util.ArrayList;
import java.util.List;

public class Example2 {

    public static void main(String args[]) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);

        System.out.println("The element at index two is " + list.get(1));

        System.out.println("The size of the List is  " + list.size());

    }
}

/*
OUTPUT:
[1, 2, 3]
The element at index two is 2
The size of the List is  3
 */