package com.manish.OOD.BehavioralDesign.Strategy.GoogleMap;

public class GoogleMaps {
    private RouteCalculatorContext context;

    public GoogleMaps(RouteCalculator calculator) {
        this.context = new RouteCalculatorContext(calculator);
    }

    public void setRouteCalculator(RouteCalculator calculator) {
        this.context = new RouteCalculatorContext(calculator);
    }

    public String calculateRoute(Location start, Location end) {
        return context.calculateRoute(start, end);
    }
}
