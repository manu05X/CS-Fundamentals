package com.manish.OOD.BehavioralDesign.Observer.DBMS;


//3. Observer interface for database record updates
public interface DatabaseRecordObserver {
    void onRecordUpdated(DatabaseRecord record);
}
