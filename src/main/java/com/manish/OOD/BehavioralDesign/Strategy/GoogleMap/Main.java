package com.manish.OOD.BehavioralDesign.Strategy.GoogleMap;

public class Main {
    public static void main(String[] args) {
        // Create a Google Maps instance with the default calculator (fastest route)
        GoogleMaps maps = new GoogleMaps(new FastestRouteCalculator());

        // Calculate the best route from New York to Boston using the default calculator
        Location start = new Location("New York");
        Location end = new Location("Boston");
        String route = maps.calculateRoute(start, end);
        System.out.println(route);

        // Change the calculator to the shortest route
        maps.setRouteCalculator(new ShortestRouteCalculator());

        // Calculate the best route from New York to Boston using the shortest route calculator
        route = maps.calculateRoute(start, end);
        System.out.println(route);

        // Change the calculator to the scenic route
        maps.setRouteCalculator(new ScenicRouteCalculator());

        // Calculate the best route from New York to Boston using the scenic route calculator
        route = maps.calculateRoute(start, end);
        System.out.println(route);
    }
}
