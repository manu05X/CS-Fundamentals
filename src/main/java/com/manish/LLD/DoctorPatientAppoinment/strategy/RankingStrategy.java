package com.manish.LLD.DoctorPatientAppoinment.strategy;

import com.manish.LLD.DoctorPatientAppoinment.model.DoctorAvailability;
import java.util.List;

public interface RankingStrategy {
    List<DoctorAvailability> rank(List<DoctorAvailability> availabilities);
}