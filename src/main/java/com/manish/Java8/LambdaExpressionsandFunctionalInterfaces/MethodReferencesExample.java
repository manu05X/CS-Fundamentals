package com.manish.Java8.LambdaExpressionsandFunctionalInterfaces;

import java.util.Arrays;
import java.util.List;

public class MethodReferencesExample {
    public MethodReferencesExample() {
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void main(String[] args) {
        List<String> messages = Arrays.asList("Hello", "World", "Method", "References", "in", "Java");
        messages.forEach(MethodReferencesExample::printMessage);
        messages.forEach(String::toUpperCase);
    }
}