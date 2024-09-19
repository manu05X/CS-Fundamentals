package com.manish.Collections.Arraylist.C_Iteration;

/*
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//The below program will fail because we are trying to delete the element from the list directly.

public class ArrayListDemo3 {

    public static void main(String args[]) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(10);

        Iterator<Integer> itr = list.iterator();

        while (itr.hasNext()) {
            int next = itr.next();

            if (next == 30) {
                list.remove(new Integer(30));
            }
        }
    }
}
*/
//The code shown below is the correct way to delete an element from the list.

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListDemo3 {

    public static void main(String args[]) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(10);

        Iterator<Integer> itr = list.iterator();

        while (itr.hasNext()) {
            int next = itr.next();

            if (next == 30) {
                itr.remove(); // Use Iterator's remove method
            }
        }

        // Print the modified list
        System.out.println(list);
    }
}
