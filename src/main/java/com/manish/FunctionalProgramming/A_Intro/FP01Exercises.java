package com.manish.FunctionalProgramming.A_Intro;

import java.util.List;

public class FP01Exercises {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);
        printAllNumbersInList(numbers);
        printEvenNumbersInListStructured(numbers);
        printOddNumbersInListFunctional(numbers);
        printSquaresOfEvenNumbersInListFunctional(numbers);
        printCubesOfOddNumbersInListFunctional(numbers);
    }

    private static void printAllNumbersInList(List<Integer> numbers){
        System.out.println("Print each number in the List");
//        numbers.stream() // Convert the list to a stream
//                .forEach(FP01Exercises::print); // Print each number using method reference
        // we used a custom method (print) to print each number in the list.
        //We can simplify this approach further by directly using System.out::println.

        numbers.stream() // Convert the list to a stream
                .forEach(System.out::println);
    }

    private static void print(int number){
        System.out.println(number); // Print the number
    }

    private static void printEvenNumbersInListStructured(List<Integer> numbers){
        System.out.println("Print the Even numbers from numbers List");
        numbers.stream() // Convert the list to a stream
                .filter(number -> number % 2 == 0) // Filter to select even numbers
                .forEach(System.out::println); // Print each even number
    }


    private static void printOddNumbersInListFunctional(List<Integer> numbers){
        System.out.println("Print the ODD numbers from numbers List");
        numbers.stream()  // Convert to Stream
                .filter(number -> number%2 != 0) // Lambda Expression
                .forEach(System.out::println); // Method Reference
    }

    private static void printSquaresOfEvenNumbersInListFunctional(List<Integer> numbers){
        System.out.println("Print the Cubes of Even numbers from numbers List");
        numbers.stream()
                .filter(number -> number%2 == 0) // Filter only even numbers
                //The map() function allows us to apply a function to each element in a stream, transforming the data in some way.
                .map(number -> number * number * number) // Map each number to its square
                .forEach(System.out::println); // Print each squared number
    }

    private static void printCubesOfOddNumbersInListFunctional(List<Integer> numbers){
        System.out.println("Print the Cubes of Odd numbers from numbers List");

        numbers.stream()
                .filter(number -> number % 2 != 0)
                .map(number -> number*number*number)
                .forEach(System.out::println);
    }

}
