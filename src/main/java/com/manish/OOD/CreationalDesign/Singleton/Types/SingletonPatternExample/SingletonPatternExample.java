package com.manish.OOD.CreationalDesign.Singleton.Types.SingletonPatternExample;

// Main class to test the Singleton pattern
public class SingletonPatternExample {
    public static void main(String[] args) {
        // Get the only object available (first call will create the instance)
        Singleton singleton1 = Singleton.getInstance(); // Output: Creating first instance, Singleton instance created

        // Get the instance again (will not create a new instance)
        Singleton singleton2 = Singleton.getInstance(); // Output: Fetching instance

        // Check if both references point to the same instance
        System.out.println("Are both instances the same? " + (singleton1 == singleton2)); // Output: Are both instances the same? true
    }
}