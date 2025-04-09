package com.manish.Java8.DefaultandStaticMethodsInterfaces;

class MyClass implements MyInterface {
    MyClass() {
    }

    public void existingMethod(String str) {
        System.out.println("The string is: " + str);
    }

    public void newDefaultMethod() {
        System.out.println("Overridden default method in MyClass.");
    }
}