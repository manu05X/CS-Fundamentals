package com.manish.Java8.FunctionalInterfaces;

import java.util.function.Predicate;

public class PredicateExample {
    public PredicateExample() {
    }

    public static void main(String[] args) {
        Predicate<Integer> isGreaterThanTen = (number) -> {
            return number > 10;
        };
        int testNumber = 15;
        if (isGreaterThanTen.test(Integer.valueOf(testNumber))) {
            System.out.println("" + testNumber + " is greater than 10");
        } else {
            System.out.println("" + testNumber + " is not greater than 10");
        }

    }
}
