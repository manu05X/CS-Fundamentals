package com.manish.OOD.BehavioralDesign.Observer.DBMS;

// Observer interface for database record updates
public interface DatabaseRecordObserver {
    void onRecordUpdated(DatabaseRecord record);
}
