package com.manish.Java8.Practice.Example8;

//8. Given a String, find the first repeated character in it using Stream functions?

import java.util.*;
import java.util.stream.*;

public class FirstRepeated {
    public static void main(String[] args) {
        String input = "Java Articles are Awesome";

        // First case: Using Stream with groupingBy to find the first repeated character
        Character result = input.chars() // Stream of characters from the string
                .mapToObj(s -> Character.toLowerCase((char) s)) // Convert each int to char, then to lowercase
                .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting())) // Group by character with count
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1L) // Find characters with a count greater than 1
                .map(Map.Entry::getKey) // Get the key (character)
                .findFirst() // Find the first matching character
                .orElse(null); // Handle if no repeated characters are found

        System.out.println("First repeated character using groupingBy: " + result);

        /* Second case: Using a Set to find the first repeated character */
        Set<Character> seenCharacters = new HashSet<>();

        // Find the first character that has been seen before
        Character firstRepeated = input.chars()
                .mapToObj(c -> Character.toLowerCase((char) c)) // Convert each int to char and make it lowercase
                .filter(c -> !seenCharacters.add(c)) // If character is already in the set, it's a repeated character
                .findFirst() // Find the first repeated character
                .orElse(null); // Handle if no repeated characters are found

        System.out.println("First repeated character using Set: " + firstRepeated);
    }
}
