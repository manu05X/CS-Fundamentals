package com.manish.LLD.Parkinglot;


import com.manish.LLD.Parkinglot.controllers.TicketController;
import com.manish.LLD.Parkinglot.repositories.GateRepository;
import com.manish.LLD.Parkinglot.repositories.ParkingLotRepository;
import com.manish.LLD.Parkinglot.repositories.TicketRepository;
import com.manish.LLD.Parkinglot.repositories.VehicleRepository;
import com.manish.LLD.Parkinglot.services.TicketService;
import com.manish.LLD.Parkinglot.strategies.spotassignmentstrategy.RandomSpotAssignmentStrategy;
import com.manish.LLD.Parkinglot.strategies.spotassignmentstrategy.SpotAssignmentStrategy;

public class Main {
    public static void main(String[] args) {
        /*
        Order of creating objects :-
            Repos, strategy -> services -> controller
            this is known as topological sorting
        */
        GateRepository gateRepository = new GateRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        TicketRepository ticketRepository = new TicketRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();
        SpotAssignmentStrategy spotAssignmentStrategy = new RandomSpotAssignmentStrategy();

        TicketService ticketService = new TicketService(
                gateRepository,
                vehicleRepository,
                spotAssignmentStrategy,
                parkingLotRepository,
                ticketRepository
        );

        TicketController ticketController = new TicketController(ticketService);

        System.out.println("Application has started on part :8080");
    }

}
