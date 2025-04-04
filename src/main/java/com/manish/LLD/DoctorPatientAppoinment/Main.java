package com.manish.LLD.DoctorPatientAppoinment;

import com.manish.LLD.DoctorPatientAppoinment.model.Doctor;
import com.manish.LLD.DoctorPatientAppoinment.model.TimeSlot;
import com.manish.LLD.DoctorPatientAppoinment.model.enums.Speciality;
import com.manish.LLD.DoctorPatientAppoinment.system.AppointmentSystem;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        AppointmentSystem system = new AppointmentSystem();

        system.registerDoctor("Curious", Speciality.CARDIOLOGIST);
        system.markDocAvailability("Curious", Arrays.asList(
                new TimeSlot("9:30", "10:00"),
                new TimeSlot("12:30", "13:00"),
                new TimeSlot("16:00", "16:30")
        ));

        system.registerDoctor("Dreadful", Speciality.DERMATOLOGIST);
        system.markDocAvailability("Dreadful", Arrays.asList(
                new TimeSlot("10:30", "11:00"),
                new TimeSlot("13:30", "14:00"),
                new TimeSlot("17:00", "17:30")
        ));

        system.showAvailableBySpeciality(Speciality.CARDIOLOGIST);
        system.bookAppointment("PatientA", "Curious", "12:30");
        system.showAvailableBySpeciality(Speciality.CARDIOLOGIST);
        system.cancelAppointment(1);
        system.showAvailableBySpeciality(Speciality.CARDIOLOGIST);
        system.bookAppointment("PatientB", "Curious", "12:30");

        system.registerDoctor("Daring", Speciality.DERMATOLOGIST);
        system.markDocAvailability("Daring", Arrays.asList(
                new TimeSlot("11:30", "12:00"),
                new TimeSlot("14:00", "14:30")
        ));

        system.showAvailableBySpeciality(Speciality.DERMATOLOGIST);

        Doctor trending = system.getTrendingDoctor();
        if (trending != null) {
            System.out.println("Trending Doctor: Dr." + trending.getName());
        }
    }
}
