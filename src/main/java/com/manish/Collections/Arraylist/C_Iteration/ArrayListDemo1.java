package com.manish.Collections.Arraylist.C_Iteration;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo1 {

    public static void main(String args[]) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        System.out.println("Simple for loop : ");
        for (int i = 0; i < list.size(); i++) { //Simple for loop
            System.out.println(list.get(i));
        }

        System.out.println("Enhanced for loop : ");
        for (Integer i : list) {   //Enhanced for loop
            System.out.println(i);
        }
    }
}

