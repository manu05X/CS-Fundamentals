package com.manish.Java8.LambdaExpressionsandFunctionalInterfaces;

public class LambdaExpressionsExample {
    public LambdaExpressionsExample() {
    }

    public static void main(String[] args) {
        GreetingService greetService1 = (message) -> {
            System.out.println("Hello " + message);
        };
        GreetingService greetService2 = (message) -> {
            System.out.println("Hello " + message);
            System.out.println("Welcome to lambda expressions in Java!");
        };
        greetService1.sayMessage("John");
        greetService2.sayMessage("Alice");
    }
}