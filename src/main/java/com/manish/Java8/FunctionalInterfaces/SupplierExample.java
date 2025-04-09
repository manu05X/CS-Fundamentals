package com.manish.Java8.FunctionalInterfaces;

import java.util.function.Supplier;

public class SupplierExample {
    public SupplierExample() {
    }

    public static void main(String[] args) {
        Supplier<String> stringSupplier = () -> {
            return "Hello, World!";
        };
        String suppliedString = (String)stringSupplier.get();
        System.out.println(suppliedString);
    }
}