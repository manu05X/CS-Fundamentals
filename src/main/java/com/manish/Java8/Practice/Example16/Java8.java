package com.manish.Java8.Practice.Example16;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Java8 {
 
    public static void main(String[] args) {
        // Initialize a list of names
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        // Convert names to uppercase using streams
        List<String> nameLst = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        // Print the list of names in uppercase
        System.out.println(nameLst);
    }
}

//16. How to use map to convert object into Uppercase in Java 8?