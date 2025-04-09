package com.manish.Java8.StreamAPIandCollectors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsPartitioningByExample {
    public CollectorsPartitioningByExample() {
    }

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        Map<Boolean, List<String>> partitionedByEmpty = (Map)strings.stream().collect(Collectors.partitioningBy((string) -> {
            return string.isEmpty();
        }));
        System.out.println("Partitioned by Empty: " + String.valueOf(partitionedByEmpty));
    }
}