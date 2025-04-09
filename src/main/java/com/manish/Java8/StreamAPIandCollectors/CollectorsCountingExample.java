package com.manish.Java8.StreamAPIandCollectors;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectorsCountingExample {
    public CollectorsCountingExample() {
    }

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        long count = (Long)strings.stream().filter((string) -> {
            return !string.isEmpty();
        }).collect(Collectors.counting());
        System.out.println("Count of non-empty strings: " + count);
    }
}