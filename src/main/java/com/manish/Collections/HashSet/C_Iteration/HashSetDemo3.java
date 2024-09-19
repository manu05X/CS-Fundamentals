package com.manish.Collections.HashSet.C_Iteration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Sorting a HashSet
Since a HashSet stores the elements in random order, it is not possible to store the elements in a HashSet in sorted order.
If we want to sort the elements of a HashSet, then we should convert it into some other Collection such as a List, TreeSet, or LinkedHashSet.

Here we will see how we can convert a HashSet to an ArrayList, and then we can use the elements from the List.
We can create an ArrayList by sending another collection to its constructor.
 We can sort this ArrayList using the sort() method of the Collections class.
 */
public class HashSetDemo3 {
    public static void main(String args[]) {
        Set<Integer> set = new HashSet<>();

        set.add(23);
        set.add(34);
        set.add(56);

        // Creating an ArrayList from existing set.
        List<Integer> list = new ArrayList<>(set);
        // Sorting the list.
        Collections.sort(list);

        list.forEach(System.out::println);
    }
}
