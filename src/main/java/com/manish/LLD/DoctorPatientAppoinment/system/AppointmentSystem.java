package com.manish.LLD.DoctorPatientAppoinment.system;

import com.manish.LLD.DoctorPatientAppoinment.model.*;
import com.manish.LLD.DoctorPatientAppoinment.model.enums.*;
import com.manish.LLD.DoctorPatientAppoinment.strategy.*;
import java.util.*;

public class AppointmentSystem {
    private List<Doctor> doctors;
    private List<Patient> patients;
    private List<Appointment> appointments;
    private List<WaitlistEntry> waitlist;
    private RankingStrategy rankingStrategy;
    
    public AppointmentSystem() {
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
        this.appointments = new ArrayList<>();
        this.waitlist = new ArrayList<>();
        this.rankingStrategy = new DefaultRankingStrategy();
    }
    
    public void registerDoctor(String name, Speciality speciality) {
        Doctor doctor = new Doctor(name, speciality);
        doctors.add(doctor);
        System.out.println("Welcome Dr. " + name + " !!");
    }
    
    public void markDocAvailability(String doctorName, List<TimeSlot> slots) {
        Doctor doctor = findDoctor(doctorName);
        if (doctor == null) {
            System.out.println("Doctor not found");
            return;
        }
        
        for (TimeSlot slot : slots) {
            doctor.declareAvailability(slot);
        }
    }
    
    public void showAvailableBySpeciality(Speciality speciality) {
        List<DoctorAvailability> availabilities = new ArrayList<>();
        
        for (Doctor doctor : doctors) {
            if (doctor.getSpeciality() == speciality) {
                for (DoctorAvailability da : doctor.getAvailabilityList()) {
                    if (da.getStatus() == SlotStatus.AVAILABLE) {
                        availabilities.add(da);
                    }
                }
            }
        }
        
        availabilities = rankingStrategy.rank(availabilities);
        
        for (DoctorAvailability da : availabilities) {
            System.out.println("Dr." + da.getDoctor().getName() + ": (" + da.getSlot() + ")");
        }
    }
    
    public Appointment bookAppointment(String patientName, String doctorName, String slotTime) {
        Patient patient = findOrCreatePatient(patientName);
        Doctor doctor = findDoctor(doctorName);
        if (doctor == null) {
            System.out.println("Doctor not found");
            return null;
        }
        
        TimeSlot requestedSlot = null;
        DoctorAvailability requestedAvailability = null;
        
        for (DoctorAvailability da : doctor.getAvailabilityList()) {
            if (da.getSlot().getStartTime().equals(slotTime) && da.getStatus() == SlotStatus.AVAILABLE) {
                requestedSlot = da.getSlot();
                requestedAvailability = da;
                break;
            }
        }
        
        if (requestedSlot == null) {
            System.out.println("Slot not available");
            WaitlistEntry entry = new WaitlistEntry(patient, doctor, new TimeSlot(slotTime, ""));
            waitlist.add(entry);
            System.out.println("Added to waitlist");
            return null;
        }
        
        if (hasAppointmentAtSlot(patient, requestedSlot)) {
            System.out.println("You already have an appointment at this time");
            return null;
        }
        
        Appointment appointment = new Appointment(doctor, patient, requestedSlot);
        appointments.add(appointment);
        requestedAvailability.setStatus(SlotStatus.BOOKED);
        patient.addAppointment(appointment);
        
        System.out.println("Booked. Booking id: " + appointment.getId());
        return appointment;
    }
    
    public void cancelAppointment(int bookingId) {
        Appointment appointment = findAppointment(bookingId);
        if (appointment == null) {
            System.out.println("Appointment not found");
            return;
        }
        
        appointment.cancel();
        
        Doctor doctor = appointment.getDoctor();
        TimeSlot slot = appointment.getSlot();
        
        for (DoctorAvailability da : doctor.getAvailabilityList()) {
            if (da.getSlot().equals(slot)) {
                da.setStatus(SlotStatus.AVAILABLE);
                break;
            }
        }
        
        processWaitlist(doctor, slot);
        System.out.println("Booking Cancelled");
    }
    
    private void processWaitlist(Doctor doctor, TimeSlot slot) {
        List<WaitlistEntry> entries = new ArrayList<>();
        
        for (WaitlistEntry entry : waitlist) {
            if (entry.getDoctor().equals(doctor) && entry.getSlot().getStartTime().equals(slot.getStartTime())) {
                entries.add(entry);
            }
        }
        
        if (!entries.isEmpty()) {
            entries.sort(Comparator.comparing(WaitlistEntry::getTimestamp));
            WaitlistEntry firstEntry = entries.get(0);
            bookAppointment(firstEntry.getPatient().getName(), doctor.getName(), slot.getStartTime());
            waitlist.remove(firstEntry);
        }
    }
    
    private boolean hasAppointmentAtSlot(Patient patient, TimeSlot slot) {
        for (Appointment a : appointments) {
            if (a.getPatient().equals(patient) && a.getSlot().equals(slot) && a.getStatus() == AppointmentStatus.BOOKED) {
                return true;
            }
        }
        return false;
    }
    
    private Doctor findDoctor(String name) {
        for (Doctor doctor : doctors) {
            if (doctor.getName().equals(name)) {
                return doctor;
            }
        }
        return null;
    }
    
    private Patient findOrCreatePatient(String name) {
        for (Patient patient : patients) {
            if (patient.getName().equals(name)) {
                return patient;
            }
        }
        
        Patient patient = new Patient(name);
        patients.add(patient);
        return patient;
    }
    
    private Appointment findAppointment(int bookingId) {
        for (Appointment appointment : appointments) {
            if (appointment.getId() == bookingId) {
                return appointment;
            }
        }
        return null;
    }
    
    public Doctor getTrendingDoctor() {
        Map<Doctor, Integer> appointmentCount = new HashMap<>();
        
        for (Appointment a : appointments) {
            if (a.getStatus() == AppointmentStatus.BOOKED) {
                appointmentCount.put(a.getDoctor(), appointmentCount.getOrDefault(a.getDoctor(), 0) + 1);
            }
        }
        
        return appointmentCount.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }
}