package com.manish.LLD.DoctorPatientAppoinment.model;

import com.manish.LLD.DoctorPatientAppoinment.model.enums.Speciality;

import java.util.ArrayList;
import java.util.List;

public class Doctor {
    private String name;
    private Speciality speciality;
    private double rating;
    private List<DoctorAvailability> availabilityList;

    public Doctor(String name, Speciality speciality){
        this.speciality = speciality;
        this.name = name;
        this.rating = 0.0;
        this.availabilityList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public double getRating() {
        return rating;
    }

    public List<DoctorAvailability> getAvailabilityList() {
        return availabilityList;
    }

    public void declareAvailability(TimeSlot slot){
        if (!isValidSlot(slot)) {
            System.out.println("Sorry Dr. " + name + " slots are 30 mins only");
            return;
        }

        if (hasOverlap(slot)) {
            System.out.println("Sorry Dr. " + name + " this slot overlaps with existing slots");
            return;
        }

        availabilityList.add(new DoctorAvailability(this, slot));
        System.out.println("Done Doc!");
    }

    private boolean isValidSlot(TimeSlot slot){

        return true;
    }

    private boolean hasOverlap(TimeSlot newSlot) {
        for (DoctorAvailability da : availabilityList) {
            TimeSlot existingSlot = da.getSlot();
            if (isOverlap(existingSlot, newSlot)) {
                return true;
            }
        }
        return false;
    }

    private boolean isOverlap(TimeSlot slot1, TimeSlot slot2) {
        return slot1.equals(slot2);
    }


}
