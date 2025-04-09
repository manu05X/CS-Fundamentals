package com.manish.Java8.DefaultandStaticMethodsInterfaces;

interface MyStaticInterface {
    static void staticMethod() {
        System.out.println("This is a static method in the interface.");
    }

    void instanceMethod();
}