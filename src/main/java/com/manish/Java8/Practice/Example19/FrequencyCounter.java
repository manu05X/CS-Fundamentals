package com.manish.Java8.Practice.Example19;

import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

public class FrequencyCounter {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
        
        // Count frequency of "apple"
        long count = words.stream()
                         .filter(word -> word.equals("apple"))
                         .count();
        
        System.out.println("Frequency of 'apple': " + count); // Output: 3


        Map<String, Long> frequencyMap = words.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));

        System.out.println(frequencyMap);


//        long count2 = Collections.frequency(words, "apple");
//        // Or as a stream operation:
//        long streamCount = words.stream()
//                .filter(word -> Collections.frequency(words, word) > 1)
//                .count();
//
//        System.out.println(streamCount);
    }
}