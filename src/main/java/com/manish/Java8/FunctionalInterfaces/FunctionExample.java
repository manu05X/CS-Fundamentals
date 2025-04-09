package com.manish.Java8.FunctionalInterfaces;

import java.util.function.Function;

public class FunctionExample {
    public FunctionExample() {
    }

    public static void main(String[] args) {
        Function<String, Integer> stringLength = (str) -> {
            return str.length();
        };
        String testString = "Hello, World!";
        int length = (Integer)stringLength.apply(testString);
        System.out.println("The length of \"" + testString + "\" is " + length);
    }
}