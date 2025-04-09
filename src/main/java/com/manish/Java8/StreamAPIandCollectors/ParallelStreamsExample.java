package com.manish.Java8.StreamAPIandCollectors;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParallelStreamsExample {
    public ParallelStreamsExample() {
    }

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        List<String> filtered = (List)strings.parallelStream().filter((string) -> {
            return !string.isEmpty();
        }).collect(Collectors.toList());
        System.out.println("Filtered List (Parallel Stream): " + String.valueOf(filtered));
    }
}