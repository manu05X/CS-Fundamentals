package com.manish.Java8.StreamAPIandCollectors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsGroupingByExample {
    public CollectorsGroupingByExample() {
    }

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "ab", "bc", "efg", "abcd", "jkl");
        Map<Integer, List<String>> groupedByLength = (Map)strings.stream().collect(Collectors.groupingBy(String::length));
        System.out.println("Grouped by Length: " + String.valueOf(groupedByLength));
    }
}