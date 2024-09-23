package com.manish.Java8.Practice.Example15;

import java.util.Arrays;


public class Java8 {

    public static void main(String[] args) {
        int arr[] = { 99, 55, 203, 99, 4, 91 };
        Arrays.parallelSort(arr); // Sort the array using parallelSort()

        // Convert the sorted array into a Stream and print each element
        Arrays.stream(arr).forEach(n -> System.out.print(n + " "));
    }
}

//15. Write a Java 8 program to sort an array and then convert the sorted array into Stream?