package com.manish.Java8.StreamAPIandCollectors;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class CollectorsSummarizingExample {
    public CollectorsSummarizingExample() {
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 5, 8, 1, 9, 12, 4);
        IntSummaryStatistics stats = (IntSummaryStatistics)numbers.stream().collect(Collectors.summarizingInt(Integer::intValue));
        System.out.println("Summary Statistics: " + String.valueOf(stats));
    }
}