package com.manish.Java8.Practice.Example3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UniqueElements {
    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 3, 2, 4, 5, 1};
        
        List<Integer> uniqueNumbers = Arrays.stream(numbers)
                                          .distinct()
                                          .collect(Collectors.toList());
        
        System.out.println(uniqueNumbers); // Output: [1, 2, 3, 4, 5]
    }
}