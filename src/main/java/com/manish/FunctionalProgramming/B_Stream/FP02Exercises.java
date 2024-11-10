package com.manish.FunctionalProgramming.B_Stream;

import java.util.List;

public class FP02Exercises {
    public static void main(String[] args) {
        // Step 1: Create a list of numbers
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        // Step 2: Calculate the sum using the structured approach
        System.out.println(addListStructured(numbers));  // Output: 77
        System.out.println(addListFunctional(numbers));
        System.out.println(addListParallel(numbers));
    }


    // Step 3: Define a method to calculate the sum
    private static int addListStructured(List<Integer> numbers) {
        int sum = 0;  // Initialize sum to 0

        // Loop over each number in the list and add it to sum
        for (int number : numbers) {
            sum += number;
        }

        // Return the final sum
        return sum;
    }


    private static int addListFunctional(List<Integer> numbers){
        System.out.println("Summing Numbers with the Functional Approach Using reduce : ");

        return numbers.stream()
                .reduce(0, Integer::sum); // Reduce the numbers to their sum
    }

    private static int addListParallel(List<Integer> numbers){
        System.out.println("Summing Numbers with the Functional Approach Using reduce and Parallel Streams : ");

        return numbers.parallelStream()
                .reduce(0, Integer::sum);

        //The parallelStream() method divides the list into smaller parts, processing them in parallel across multiple threads.
        //
        //The reduce operation remains the same but is now executed concurrently, which can improve performance for larger datasets.
    }
}
