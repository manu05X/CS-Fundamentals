package com.manish.Java8.Practice.Example3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DuplicateElements {
    public static void main(String[] args) {
        List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);

        // Correctly typed HashSet
        Set<Integer> set = new HashSet<>();
        myList.stream()
                .filter(n -> !set.add(n)) // Filters out elements that already exist in the set
                .forEach(System.out::println); // Prints the duplicate elements

        System.out.println("getDataWithoutDuplicates1() : ");
        getDataWithoutDuplicates1();

        System.out.println("getDataWithoutDuplicates2() : ");
        getDataWithoutDuplicates2();

        System.out.println("getDataWithoutDuplicates3() : ");
        getDataWithoutDuplicates3(myList);
    }

    // Method 1: Using distinct()
    public static void getDataWithoutDuplicates1() {
        List<Integer> myList = Arrays.asList(1, 1, 85, 6, 2, 3, 65, 6, 45, 45, 5662, 2582, 2, 2, 266, 666, 656);
        myList.stream().distinct().forEach(System.out::println);
    }

    // Method 2: Using a Set to remove duplicates
    public static void getDataWithoutDuplicates2() {
        List<Integer> myList = Arrays.asList(1, 1, 85, 6, 2, 3, 65, 6, 45, 45, 5662, 2582, 2, 2, 266, 666, 656);
        Set<Integer> set = new HashSet<>(myList);

        // Convert the set back to a list if needed and print unique elements
        List<Integer> uniqueData = set.stream().collect(Collectors.toList());
        uniqueData.forEach(System.out::println);
    }

    // Method 3: Using distinct() on an existing List
    public static void getDataWithoutDuplicates3(List<Integer> arr) {
        // No need for Arrays.stream() as `arr` is already a List
        List<Integer> list = arr.stream().distinct().collect(Collectors.toList());
        list.forEach(System.out::println); // Prints unique elements
    }

    /* or can also try below single line code */
     /*
    List<Integer> list = Arrays.stream(arr).boxed().distinct().collect(Collectors.toList());
     */
}

//3. How to find duplicate elements in a given integers list in java using Stream functions?