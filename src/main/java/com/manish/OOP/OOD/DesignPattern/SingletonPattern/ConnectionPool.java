package com.manish.OOP.OOD.DesignPattern.SingletonPattern;


public class ConnectionPool {
    //Step - 3 - Local Attribute
    private static ConnectionPool INSTANCE = null;
    //Step - 1 - Constructor Hiding
    private ConnectionPool(){}

    //Step - 2 - Global access Point
    public static ConnectionPool getInstance(){
        //Step - 4 - If Instance is not NULL
        //ELSE create, store and return
        if (INSTANCE == null) {
            // Step 4
            synchronized (ConnectionPool.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ConnectionPool();
                }
            }
        }
        return INSTANCE;
    }
}
// Cons of this approach:
// 1. SRP violation
// 2. Thread safety is not guaranteed
// 3. Performance is not guaranteed in thread-safe mode - Double checked locking
// Enum implementation, inner static class