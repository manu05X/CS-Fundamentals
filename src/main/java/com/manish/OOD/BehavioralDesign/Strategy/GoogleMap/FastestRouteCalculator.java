package com.manish.OOD.BehavioralDesign.Strategy.GoogleMap;

public class FastestRouteCalculator implements RouteCalculator {
    @Override
    public String calculateRoute(Location start, Location end) {
        // Calculate the fastest route using Google Maps API
        return "Fastest route from " + start + " to " + end;
    }
}
