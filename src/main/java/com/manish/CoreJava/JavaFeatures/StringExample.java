package com.manish.CoreJava.JavaFeatures;

public class StringExample {
    public StringExample() {
    }

    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "World";
        String str3 = str1 + " " + str2;
        System.out.println("Concatenated string: " + str3);
        System.out.println("Length of str3: " + str3.length());
        System.out.println("Character at index 1 in str3: " + str3.charAt(1));
        System.out.println("Substring of str3 from index 6 to 11: " + str3.substring(6, 11));
    }
}