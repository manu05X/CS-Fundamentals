package com.manish.LLD.DoctorPatientAppoinment.model;

import com.manish.LLD.DoctorPatientAppoinment.model.enums.AppointmentStatus;

public class Appointment {
    private static int counter = 0;
    private int id;
    private Doctor doctor;
    private Patient patient;
    private TimeSlot slot;
    private AppointmentStatus status;
    
    public Appointment(Doctor doctor, Patient patient, TimeSlot slot) {
        this.id = ++counter;
        this.doctor = doctor;
        this.patient = patient;
        this.slot = slot;
        this.status = AppointmentStatus.BOOKED;
    }
    
    public int getId() { return id; }
    public Doctor getDoctor() { return doctor; }
    public Patient getPatient() { return patient; }
    public TimeSlot getSlot() { return slot; }
    public AppointmentStatus getStatus() { return status; }
    public void cancel() { this.status = AppointmentStatus.CANCELLED; }
}