package com.manish.Java8.FunctionalInterfaces;

import java.util.function.BinaryOperator;

public class BinaryOperatorExample {
    public BinaryOperatorExample() {
    }

    public static void main(String[] args) {
        BinaryOperator<Integer> add = (ax, bx) -> {
            return ax + bx;
        };
        int a = 5;
        int b = 10;
        int result = (Integer)add.apply(Integer.valueOf(a), Integer.valueOf(b));
        System.out.println("" + a + " + " + b + " = " + result);
    }
}