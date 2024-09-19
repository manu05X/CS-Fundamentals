package com.manish.Collections.HashSet.C_Iteration;

import java.util.HashSet;
import java.util.Set;

/*
Using forEach() method
We can use the forEach(Consumer<? super T> action) method defined in the Iterable class.
This method was introduced in Java 8. It accepts an action that needs to be performed for each element as a parameter.
 */

public class HashSetDemo2 {
    public static void main(String args[]) {
        Set<Integer> set = new HashSet<>();

        set.add(23);
        set.add(34);
        set.add(56);

        set.forEach(System.out::println);
    }
}
