package com.manish.Java8.LambdaExpressionsandFunctionalInterfaces;

public class FunctionalInterfaceExample {
    public FunctionalInterfaceExample() {
    }

    public static void main(String[] args) {
        MathOperation addition = (a, b) -> {
            return a + b;
        };
        MathOperation subtraction = (a, b) -> {
            return a - b;
        };
        MathOperation multiplication = (a, b) -> {
            return a * b;
        };
        MathOperation division = (a, b) -> {
            return a / b;
        };
        System.out.println("10 + 5 = " + operate(10, 5, addition));
        System.out.println("10 - 5 = " + operate(10, 5, subtraction));
        System.out.println("10 * 5 = " + operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + operate(10, 5, division));
    }

    private static int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }
}
