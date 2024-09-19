package com.manish.Collections.Array.C_CopyArray.Example1;

import java.util.Arrays;

//It is possible that we may only want to copy a part of our original array. In that case, we can use the copyOfRange() method. This method takes three arguments: the original array, the from index (which is inclusive), and a to index (which is exclusive).
public class ArraySDemo1 {

    public static void main(String args[]) {
        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        int[] newArray = Arrays.copyOfRange(numbers, 0, 5);

        System.out.println("The copied array is: ");

        for (int i : newArray) {
            System.out.println(i);
        }
    }
}
