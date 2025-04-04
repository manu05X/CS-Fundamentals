package com.manish.LLD.DoctorPatientAppoinment.model;

import com.manish.LLD.DoctorPatientAppoinment.model.enums.SlotStatus;

public class DoctorAvailability {
    private Doctor doctor;
    private TimeSlot slot;
    private SlotStatus status;
    
    public DoctorAvailability(Doctor doctor, TimeSlot slot) {
        this.doctor = doctor;
        this.slot = slot;
        this.status = SlotStatus.AVAILABLE;
    }
    
    public Doctor getDoctor() { return doctor; }
    public TimeSlot getSlot() { return slot; }
    public SlotStatus getStatus() { return status; }
    public void setStatus(SlotStatus status) { this.status = status; }
}