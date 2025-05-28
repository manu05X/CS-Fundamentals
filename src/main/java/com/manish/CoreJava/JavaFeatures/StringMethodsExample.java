package com.manish.CoreJava.JavaFeatures;

public class StringMethodsExample {
    public StringMethodsExample() {
    }

    public static void main(String[] args) {
        String str = "Hello World";
        String upperStr = str.toUpperCase();
        System.out.println("Uppercase: " + upperStr);
        String lowerStr = str.toLowerCase();
        System.out.println("Lowercase: " + lowerStr);
        boolean containsHello = str.contains("Hello");
        System.out.println("Contains 'Hello': " + containsHello);
        String replacedStr = str.replace('l', 'p');
        System.out.println("Replaced 'l' with 'p': " + replacedStr);
        String[] parts = str.split(" ");
        System.out.println("Split string:");
        String[] var7 = parts;
        int var8 = parts.length;

        for(int var9 = 0; var9 < var8; ++var9) {
            String part = var7[var9];
            System.out.println(part);
        }

    }
}