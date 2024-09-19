package com.manish.Collections.Arraylist.C_Iteration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//If an element is added to the ArrayList after the iterator is created then also ConcurrentModificationException will be thrown.
public class ArrayListDemo4 {

    public static void main(String args[]) {
        List<Integer> list = new ArrayList<>();
        list.add(34);
        list.add(45);

        Iterator<Integer> itr = list.iterator();
        list.add(54);

        while(itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}
