package com.manish.Java8.Practice.Example1;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,-13,13,14,-9,2,44,97,-3};

        IntStream.of(arr)
                .sorted()
                .filter(num -> num % 2 != 0)
                .forEach(num -> System.out.println(num));
    }
}

//Given a list of integers, find out all the even numbers that exist in the list using Stream functions?