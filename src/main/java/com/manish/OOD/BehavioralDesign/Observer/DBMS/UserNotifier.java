package com.manish.OOD.BehavioralDesign.Observer.DBMS;

//4. Observer that sends notifications when a record is updated
public class UserNotifier implements DatabaseRecordObserver {
    @Override
    public void onRecordUpdated(DatabaseRecord record) {
        System.out.println("User notified about new record: " + record.getId());
    }
}
