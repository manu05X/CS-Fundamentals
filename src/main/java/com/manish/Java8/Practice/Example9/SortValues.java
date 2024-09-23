package com.manish.Java8.Practice.Example9;

import java.util.*;
import java.util.stream.*;

public class SortValues {
    public static void main(String[] args) {
        // Sorting and printing elements of a List
        List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);

        // Sort the list and print the sorted elements
        myList.stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("Sorted array:");

        /* Sorting an array and printing the sorted list */
        int[] arr = {10, 15, 8, 49, 25, 98, 98, 32, 15, 26, 47};

        // Sort the array, box it to Integer, collect into a List, and print the result
        List<Integer> sortedList = Arrays.stream(arr) // Stream of int
                .boxed() // Box int to Integer
                .sorted() // Sort
                .collect(Collectors.toList()); // Collect to a List

        sortedList.forEach(System.out::println); // Print the sorted list
    }
}


//9. Given a list of integers, sort all the values present in it using Stream functions?