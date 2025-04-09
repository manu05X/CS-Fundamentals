package com.manish.Java8.FunctionalInterfaces;

import java.util.function.UnaryOperator;

public class UnaryOperatorExample {
    public UnaryOperatorExample() {
    }

    public static void main(String[] args) {
        UnaryOperator<Integer> increment = (x) -> {
            return x + 1;
        };
        int value = 5;
        int incrementedValue = (Integer)increment.apply(Integer.valueOf(value));
        System.out.println("Incremented value of " + value + " is " + incrementedValue);
    }
}