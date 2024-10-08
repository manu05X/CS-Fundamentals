package com.manish.OOD.BehavioralDesign.Observer.DBMS;


// Main class to demonstrate the Observer Pattern in action
public class Main {
    public static void main(String[] args) {
        // 2. Create a new database
        Database database = new Database();

        //4 Register the CacheUpdater and UserNotifier as observers
        CacheUpdater cacheUpdater = new CacheUpdater();
        UserNotifier userNotifier = new UserNotifier();

        // 2
        database.addRecordObserver(cacheUpdater);
        database.addRecordObserver(userNotifier);

        //1 Create a new record
        DatabaseRecord record = new DatabaseRecord(1, "John Doe", "johndoe@example.com");

        // Update the record, which will notify all observers
        database.updateRecord(record);
    }
}

/*
1. DatabaseRecord: Represents the record in the database, with fields id, name, and email. Includes constructors, getters, and setters.
2. Database: Maintains a list of observers and notifies them when a record is updated.
3. DatabaseRecordObserver: Interface that any observer (e.g., CacheUpdater, UserNotifier) must implement.
4. CacheUpdater: Updates the cache when a record is updated.
4. UserNotifier: Sends notifications when a record is updated.

5. Main: Demonstrates adding observers to the database and updating a record, which triggers the observers.


When the updateRecord method is called on the Database object, it will notify all its observers that the record has been updated. The CacheUpdater and UserNotifier objects will receive the notification and perform their specific actions. In this example, the CacheUpdater will update the cache and print a message to the console, and the UserNotifier will send a notification to the user and print a message to the console.
 */