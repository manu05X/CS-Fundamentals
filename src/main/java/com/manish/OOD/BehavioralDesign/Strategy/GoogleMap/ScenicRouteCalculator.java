package com.manish.OOD.BehavioralDesign.Strategy.GoogleMap;

public class ScenicRouteCalculator implements RouteCalculator {
    @Override
    public String calculateRoute(Location start, Location end) {
        // Calculate the scenic route using Google Maps API
        return "Scenic route from " + start + " to " + end;
    }
}
