package com.manish.LLD.DoctorPatientAppoinment.model;

public class WaitlistEntry {
    private Patient patient;
    private Doctor doctor;
    private TimeSlot slot;
    private long timestamp;
    
    public WaitlistEntry(Patient patient, Doctor doctor, TimeSlot slot) {
        this.patient = patient;
        this.doctor = doctor;
        this.slot = slot;
        this.timestamp = System.currentTimeMillis();
    }
    
    public Patient getPatient() { return patient; }
    public Doctor getDoctor() { return doctor; }
    public TimeSlot getSlot() { return slot; }
    public long getTimestamp() { return timestamp; }
}