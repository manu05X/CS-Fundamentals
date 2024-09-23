package com.manish.Codes.CoreJava.CreationalPatterns.Singleton.Example1;

// Main class to test the Singleton pattern
public class SingletonPatternExample {
    public static void main(String[] args) {
        // Get the only object available
        Singleton singleton1 = Singleton.getInstance(); // Output: Singleton instance created
        Singleton singleton2 = Singleton.getInstance();

        // Check if both references point to the same instance
        System.out.println("Are both instances the same? " + (singleton1 == singleton2)); // Ouitput: Are both instances the same? true
    }
}
