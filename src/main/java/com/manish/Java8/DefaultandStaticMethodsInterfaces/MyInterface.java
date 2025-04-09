package com.manish.Java8.DefaultandStaticMethodsInterfaces;

interface MyInterface {
    void existingMethod(String str);

    default void newDefaultMethod() {
        System.out.println("This is a default method in the interface.");
    }
}