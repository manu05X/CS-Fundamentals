package com.manish.Collections.HashSet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashSetExercise {
    public static void main(String args[]) {
        Set<Integer> set = new HashSet<>();
        int[] data = {12, 34, 1, 56, 43, 34, 65};
        int duplicate = 0;

        for(int i : data){
            if(!set.add(i)){
                duplicate = i;
                break;
            }
        }

        System.out.println(duplicate);
    }
}
/*
Solution to HashSet exercise
We know that when we insert an element into a HashSet it returns false if the element is already present.
To solve this problem we will insert each element into the HashSet.
If for a particular element false is returned, then it means the element is a duplicate.
 */
