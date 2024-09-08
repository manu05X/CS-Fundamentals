package com.manish.OOD.BehavioralDesign.Strategy.GoogleMap;

public class RouteCalculatorContext {
    private RouteCalculator calculator;

    public RouteCalculatorContext(RouteCalculator calculator) {
        this.calculator = calculator;
    }

    public String calculateRoute(Location start, Location end) {
        return calculator.calculateRoute(start, end);
    }
}
