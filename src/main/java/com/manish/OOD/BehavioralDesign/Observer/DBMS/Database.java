package com.manish.OOD.BehavioralDesign.Observer.DBMS;

import java.util.ArrayList;
import java.util.List;

//2. Class representing the database
public class Database {
    private List<DatabaseRecordObserver> observers = new ArrayList<>();

    // Method to add an observer
    public void addRecordObserver(DatabaseRecordObserver observer) {
        observers.add(observer);
    }

    // Method to update a record and notify all observers
    public void updateRecord(DatabaseRecord record) {
        // Simulate saving the updated record to the database
        System.out.println("Record updated in the database: " + record.getId());

        // Notify all observers about the record update
        for (DatabaseRecordObserver observer : observers) {
            observer.onRecordUpdated(record);
        }
    }
}
