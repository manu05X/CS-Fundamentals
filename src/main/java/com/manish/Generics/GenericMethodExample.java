package com.manish.Generics;

public class GenericMethodExample {

    // Corrected generic method to print array
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5};
        System.out.print("Integer Array: ");
        printArray(intArray);

        String[] strArray = {"A", "B", "C", "D"};
        System.out.print("String Array: ");
        printArray(strArray);
    }
}