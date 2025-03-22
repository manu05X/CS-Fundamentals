package com.manish.LLD.Parkinglot.services;



import com.manish.LLD.Parkinglot.exceptions.InvalidGateException;
import com.manish.LLD.Parkinglot.exceptions.NoAvailableSpotException;
import com.manish.LLD.Parkinglot.models.*;
import com.manish.LLD.Parkinglot.repositories.GateRepository;
import com.manish.LLD.Parkinglot.repositories.ParkingLotRepository;
import com.manish.LLD.Parkinglot.repositories.TicketRepository;
import com.manish.LLD.Parkinglot.repositories.VehicleRepository;
import com.manish.LLD.Parkinglot.strategies.spotassignmentstrategy.SpotAssignmentStrategy;

import java.util.Date;
import java.util.Optional;

public class TicketService {

    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private SpotAssignmentStrategy spotAssignmentStrategy;
    private ParkingLotRepository parkingLotRepository;
    private TicketRepository ticketRepository;

    //Dependency Injection
    public TicketService(GateRepository gateRepository,
                         VehicleRepository vehicleRepository,
                         SpotAssignmentStrategy spotAssignmentStrategy,
                         ParkingLotRepository parkingLotRepository,
                         TicketRepository ticketRepository) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.spotAssignmentStrategy = spotAssignmentStrategy;
        this.parkingLotRepository = parkingLotRepository;
        this.ticketRepository = ticketRepository;
    }

    // This return a ticket object to controller
    // Now controller will ensure that client will get relevant ticket i.e by converting this object to
    // relevant ticketResponseDto as per required by client or our system to print ticket
    public Ticket generateTicket(
            Long gateID, VehicalType vehicalType, String vehicleNumber
    ) throws InvalidGateException, NoAvailableSpotException //if and only if a lot of params then we can use Builder design pattern
    {

        /*
        How do we get to ticket object? -> i.e to Ticket ticket = Someting

        Ans -> Goal it to get to Ticket ticket = Someting

        1> parking spot using strategy design pattern
        2> we need to have vehicle, but we only have vehicleType and vehicleNumber so
            Vehicle = check if already in DB. If yes, get that. Else, create
        3> we need to have operator name that we get from gate as we have gateID
        4> so Gate = get gate for that id from db. Else throw an exception

        below

        1> Gate = get gate for that id from db. Else throw an exception
        2> Operator = from gate
        3> Vehicle = check if already in DB. If yes, get that. Else, create
        4> ParkingSpot = strategy
        5> Ticket ticket =
        */

        //1> Gate = get gate for that id from db. Else throw an exception
        Optional<Gate> gateOptional = gateRepository.findGateById(gateID);
        //here we can check if gateOptional is empty or not

        if (gateOptional.isEmpty()) {
            throw new InvalidGateException();
        }

        Gate gate = gateOptional.get();
        //2> 2> Operator = from gate
        Operator operator = gate.getCurrentOperator();

        //3> Vehicle = check if already in DB. If yes, get that. Else, create
        Optional<Vehical> vehicleOptional = vehicleRepository.findVehicleByNumber(vehicleNumber);

        Vehical vehicle ;
        //If vehicleOptional is empty then create it
        if (vehicleOptional.isEmpty()) {
            vehicle = new Vehical();
            vehicle.setVehicleNumber(vehicleNumber);
            vehicle.setVehicleType(vehicalType);

            vehicle = vehicleRepository.save(vehicle); //Saving the vehicle to vehicle repositories
        }
        else {
            vehicle = vehicleOptional.get();
        }

        //4> ParkingSpot = strategy
        // first we need to get ParkingLot
        Optional<ParkingLot> parkingLot = parkingLotRepository.getParkingLotOfGate(gate);

        if (parkingLot.isEmpty()) {
            throw new RuntimeException();
        }

        //ParkingSpot
        Optional<ParkingSpot> parkingSpotOptional = spotAssignmentStrategy.findSpot(
                vehicalType, parkingLot.get(), gate
        );

        if (parkingSpotOptional.isEmpty()) {
            throw new NoAvailableSpotException(); // NoAvailableSpotException
        }

        ParkingSpot parkingSpot = parkingSpotOptional.get();

        Ticket ticket = new Ticket();
        ticket.setGate(gate);
        ticket.setOperator(operator);
        ticket.setParkingSpot(parkingSpot);
        ticket.setEntryTime(new Date());
        ticket.setVehical(vehicle);


        //return ticket;
        return ticketRepository.save(ticket);

    }
//    public Ticket generateTicket(
//            GenerateTicketArgumentsBuilder arguments // if and only if a lot of params
//    ) {
//        return null;
//    }
}
