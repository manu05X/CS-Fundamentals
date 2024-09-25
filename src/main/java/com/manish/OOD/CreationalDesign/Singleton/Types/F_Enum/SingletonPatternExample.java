package com.manish.OOD.CreationalDesign.Singleton.Types.F_Enum;

// Enum Singleton
enum Singleton {
    INSTANCE;

    // Singleton-specific methods can be added here
    public void showMessage() {
        System.out.println("Hello from Singleton!");
    }
}

// Main class to test the Singleton pattern
public class SingletonPatternExample {
    public static void main(String[] args) {
        // Get the singleton instance
        Singleton singleton1 = Singleton.INSTANCE;

        // Call the method
        singleton1.showMessage(); // Output: Hello from Singleton!

        // Get the singleton instance again
        Singleton singleton2 = Singleton.INSTANCE;

        // Check if both references point to the same instance
        System.out.println("Are both instances the same? " + (singleton1 == singleton2)); // Output: Are both instances the same? true
    }
}
