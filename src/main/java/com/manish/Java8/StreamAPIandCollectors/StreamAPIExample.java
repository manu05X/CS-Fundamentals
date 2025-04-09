package com.manish.Java8.StreamAPIandCollectors;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPIExample {
    public StreamAPIExample() {
    }

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        List<String> filtered = (List)strings.stream().filter((string) -> {
            return !string.isEmpty();
        }).collect(Collectors.toList());
        System.out.println("Filtered List: " + String.valueOf(filtered));
        List<Integer> lengths = (List)strings.stream().filter((string) -> {
            return !string.isEmpty();
        }).map(String::length).collect(Collectors.toList());
        System.out.println("Lengths of non-empty strings: " + String.valueOf(lengths));
    }
}