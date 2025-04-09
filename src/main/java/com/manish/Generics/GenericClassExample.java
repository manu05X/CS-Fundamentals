package com.manish.Generics;

import java.io.PrintStream;

public class GenericClassExample {
    public GenericClassExample() {
    }

    public static void main(String[] args) {
        Pair<Integer, String> pair = new Pair(1, "One");
        PrintStream var10000 = System.out;
        String var10001 = String.valueOf(pair.getFirst());
        var10000.println("First: " + var10001 + ", Second: " + (String)pair.getSecond());
        Pair<String, Double> anotherPair = new Pair("Pi", 3.14);
        var10000 = System.out;
        var10001 = (String)anotherPair.getFirst();
        var10000.println("First: " + var10001 + ", Second: " + String.valueOf(anotherPair.getSecond()));
    }
}