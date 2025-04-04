package com.manish.LLD.DoctorPatientAppoinment.strategy;

import com.manish.LLD.DoctorPatientAppoinment.model.DoctorAvailability;
import java.util.Comparator;
import java.util.List;

public class DefaultRankingStrategy implements RankingStrategy {
    @Override
    public List<DoctorAvailability> rank(List<DoctorAvailability> availabilities) {
        availabilities.sort(Comparator.comparing(da -> da.getSlot().getStartTime()));
        return availabilities;
    }
}