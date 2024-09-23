package com.manish.Java8.Practice.Example20;

import java.util.*;

public class TestNotes {

    public static void main(String[] args) {
        List<Notes> noteLst = Arrays.asList(
            new Notes(1, "note1"),
            new Notes(2, "note2"),
            new Notes(3, "note3"),
            null // Example of a null entry
        );

        Optional.ofNullable(noteLst)
                .orElseGet(Collections::emptyList) // Creates an empty immutable list if noteLst is null
                .stream()
                .filter(Objects::nonNull) // Filter out null objects
                .map(Notes::getTagName) // Use method reference to get tag names
                .forEach(System.out::println); // Print tag names
    }
}

//20. How to check if list is empty in Java 8 using Optional, if not null iterate through the list and print the object?
