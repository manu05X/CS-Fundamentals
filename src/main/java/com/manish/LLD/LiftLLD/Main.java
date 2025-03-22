package com.manish.LLD.LiftLLD;

import com.manish.LLD.LiftLLD.models.Lift;
import com.manish.LLD.LiftLLD.service.LiftController;

public class Main {
    public static void main(String[] args) {
        Lift lift = new Lift(0); // Start from Ground Floor
        LiftController controller = new LiftController(lift);

        controller.requestLift(3); // User at floor 3 requests the lift
        controller.selectFloor(5); // User inside lift selects floor 5

        controller.requestLift(1); // Another user requests from floor 1
        controller.selectFloor(0); // Inside, someone selects ground floor

        controller.handleEmergency(); // Simulating an emergency
    }
}
