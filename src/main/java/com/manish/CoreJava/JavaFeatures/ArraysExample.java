package com.manish.CoreJava.JavaFeatures;

import java.util.Arrays;

public class ArraysExample {
    public ArraysExample() {
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{5, 3, 8, 2, 9};
        System.out.println("Array: " + Arrays.toString(numbers));
        Arrays.sort(numbers);
        System.out.println("Sorted array: " + Arrays.toString(numbers));
        int index = Arrays.binarySearch(numbers, 8);
        System.out.println("Index of 8: " + index);
        int[] filledArray = new int[5];
        Arrays.fill(filledArray, 7);
        System.out.println("Filled array: " + Arrays.toString(filledArray));
        int[] copiedArray = Arrays.copyOf(numbers, numbers.length);
        System.out.println("Copied array: " + Arrays.toString(copiedArray));
    }
}