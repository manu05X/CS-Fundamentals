package com.manish.Java8.FunctionalInterfaces;

import java.util.function.Consumer;

public class ConsumerExample {
    public ConsumerExample() {
    }

    public static void main(String[] args) {
        Consumer<String> printWithPrefix = (str) -> {
            System.out.println("Prefix: " + str);
        };
        String testString = "Hello, World!";
        printWithPrefix.accept(testString);
    }
}