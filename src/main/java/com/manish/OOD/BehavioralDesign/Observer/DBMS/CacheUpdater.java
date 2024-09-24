package com.manish.OOD.BehavioralDesign.Observer.DBMS;

//4. Observer that updates cache when a record is updated
public class CacheUpdater implements DatabaseRecordObserver {
    @Override
    public void onRecordUpdated(DatabaseRecord record) {
        System.out.println("Cache updated with new record: " + record.getId());
    }
}
