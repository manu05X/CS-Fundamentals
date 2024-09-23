package com.manish.Java8.Practice.Example18;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestNotes {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("AA", "BB", "AA", "CC");
        Map<String,Long> namesCount = names
                                .stream()
                                .collect(
                                 Collectors.groupingBy(
                                  Function.identity(), Collectors.counting()));
        System.out.println(namesCount);
  }
}

//18. How to count each element/word from the String ArrayList in Java8?