package com.manish.Java8.DefaultandStaticMethodsInterfaces;

public class DefaultMethodsExample {
    public DefaultMethodsExample() {
    }

    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.existingMethod("Hello, world!");
        obj.newDefaultMethod();
    }
}