package com.manish.Collections.Array.A_Search;


import java.util.Arrays;

public class ArraysDemo1 {

    public static void main(String args[]) {

        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        int index = Arrays.binarySearch(numbers, 5, 9, 4);

        System.out.println("The index of element 4 in the array is " + index);

        index = Arrays.binarySearch(numbers, 1, 5, 4);

        System.out.println("The index of element 4 in the array is " + index);

    }
}
