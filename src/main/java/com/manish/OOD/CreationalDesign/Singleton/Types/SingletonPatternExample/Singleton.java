package com.manish.OOD.CreationalDesign.Singleton.Types.SingletonPatternExample;

// Singleton class
class Singleton {
    // Static variable to hold the single instance of the class
    // Using 'volatile' to ensure visibility of changes to 'instance' across threads
    private static volatile Singleton instance;

    // Private constructor to prevent instantiation from outside
    private Singleton() {
        // Guard clause to prevent reflection-based instantiation
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method to create");
        }
        System.out.println("Singleton instance created");
    }

    // Method to maintain singleton property during deserialization
    protected Object readResolve() {
        return getInstance();
    }

    // Prevent cloning of the singleton instance
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Singleton, cannot be cloned");
    }

    // Static method to get the single instance of the class
    public static Singleton getInstance() {
        // First check for existing instance without synchronization for performance
        if (instance == null) {
            // Synchronize on the class to ensure thread safety during instantiation
            synchronized (Singleton.class) {
                // Double-checked locking to avoid unnecessary synchronization
                if (instance == null) {
                    System.out.println("Creating first instance");
                    instance = new Singleton();
                }
            }
        }
        System.out.println("Fetching instance");
        return instance;
    }
}
