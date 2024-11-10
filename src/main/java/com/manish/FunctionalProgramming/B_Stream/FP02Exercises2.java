package com.manish.FunctionalProgramming.B_Stream;

import java.util.List;

public class FP02Exercises2 {
    public static void main(String[] args){
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        // Step 1: Use a custom sum function with a sysout to print the values being passed to a and b
        int sum = numbers.stream()
                .reduce(0, (a,b) -> {
                   System.out.println("a: " + a + ", b: " + b); // Print current values of a and b
                   return a+b; // Return the sum of a and b
                });

        System.out.println("Sum : " +sum); // Output the final sum
    }
}

/*
The reduce method takes an initial value (0 in this case) and combines each element in the stream with an accumulator function.

We print out the values of a (the aggregate) and b (the next number in the list) during each step of the reduction process.

The output shows how values are accumulated step-by-step.


a: 0, b: 12
a: 12, b: 9
a: 21, b: 13
a: 34, b: 4
a: 38, b: 6
a: 44, b: 2
a: 46, b: 4
a: 50, b: 12
a: 62, b: 15
Sum: 77


The reduction starts with an initial value of 0 (the identity).

Each number from the list is added to the current aggregate value.

0 + 12 = 12
12 + 9 = 21
21 + 13 = 34, and so on.

The final result is the sum of all numbers: 77.

 */