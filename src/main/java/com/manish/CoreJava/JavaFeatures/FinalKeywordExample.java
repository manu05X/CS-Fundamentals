package com.manish.CoreJava.JavaFeatures;

import java.io.PrintStream;
import java.util.Objects;

public class FinalKeywordExample {
    final int finalVar = 100;

    public FinalKeywordExample() {
    }

    public final void finalMethod() {
        System.out.println("Inside final method.");
    }

    public static void main(String[] args) {
        FinalKeywordExample example = new FinalKeywordExample();
        PrintStream var10000 = System.out;
        Objects.requireNonNull(example);
        var10000.println("Final variable: " + 100);
        example.finalMethod();
    }
}
