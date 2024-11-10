package com.manish.FunctionalProgramming.B_Stream;

import java.util.List;

public class FP02Exercises3 {
    public static void main(String[] args){
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        // Step 1: Use a lambda expression to sum the numbers
        int sum1 = numbers.stream()
                .reduce(0,(a,b) -> a+b); // Lambda to add two numbers
        System.out.println("Sum1: " +sum1); // Output the final sum

        // Step 1: Use method reference Integer::sum to perform the reduction
        int sum2 = numbers.stream()
                .reduce(0, Integer::sum);  // Method reference to sum numbers

        System.out.println("Sum2: " +sum2); // Output the final sum
    }
}
