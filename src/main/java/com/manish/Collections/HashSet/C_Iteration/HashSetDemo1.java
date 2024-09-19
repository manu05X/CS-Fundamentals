package com.manish.Collections.HashSet.C_Iteration;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
Using Iterator
HashSet can also be iterated using an iterator as shown in the below example.
 */
public class HashSetDemo1 {
    public static void main(String args[]) {
        Set<Integer> set = new HashSet<>();

        set.add(23);
        set.add(34);
        set.add(56);

        Iterator<Integer> itr = set.iterator();

        while(itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}