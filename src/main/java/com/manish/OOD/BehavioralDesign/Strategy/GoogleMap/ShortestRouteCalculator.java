package com.manish.OOD.BehavioralDesign.Strategy.GoogleMap;

public class ShortestRouteCalculator implements RouteCalculator {
    @Override
    public String calculateRoute(Location start, Location end) {
        // Calculate the shortest route using Google Maps API
        return "Shortest route from " + start + " to " + end;
    }
}
