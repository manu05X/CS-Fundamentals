package com.manish.Java8.Practice.Example22;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharacterCount {

    public static void main(String[] args) {
        String input = "Hello World!";

        // Call the method to find and print character counts
        findCountOfChars(input);
    }

    public static void findCountOfChars(String s) {
        // Using LinkedHashMap to maintain the order of characters
        Map<String, Long> map = Arrays.stream(s.split(""))
                .map(String::toLowerCase) // Convert to lowercase
                .collect(Collectors.groupingBy(
                        str -> str,
                        LinkedHashMap::new,
                        Collectors.counting() // Count occurrences
                ));

        // Print the results
        map.forEach((character, count) -> {
            System.out.println("Character: '" + character + "' Count: " + count);
        });
    }
}

//22. Write a program to print the count of each character in a String?