package com.manish.Java8.Practice.Example21;

import java.util.Arrays;

public class MaxElementFinder {

    public static void main(String[] args) {
        // Sample array
        int[] arr = {3, 5, 7, 2, 8, 6, 1};

        // Find the maximum element
        int maxElement = findMaxElement(arr);

        // Print the result
        System.out.println("The maximum element in the array is: " + maxElement);
    }

    public static int findMaxElement(int[] arr) {
        // Use Streams to find the maximum element
        return Arrays.stream(arr)
                     .max()
                     .orElseThrow(() -> new IllegalArgumentException("Array is empty")); // Handle empty array case
    }
}

// 21. Write a Program to find the Maximum element in an array?