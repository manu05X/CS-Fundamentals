package com.manish.Java8.DefaultandStaticMethodsInterfaces;

public class StaticMethodsInInterfaceExample {
    public StaticMethodsInInterfaceExample() {
    }

    public static void main(String[] args) {
        MyStaticInterface.staticMethod();
        MyStaticClass obj = new MyStaticClass();
        obj.instanceMethod();
    }
}