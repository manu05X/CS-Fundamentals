package com.manish.LLD.Parkinglot.controllers;


import com.manish.LLD.Parkinglot.dtos.GenerateTicketRequestDto;
import com.manish.LLD.Parkinglot.dtos.GenerateTicketResponseDto;
import com.manish.LLD.Parkinglot.dtos.ResponseStatus;
import com.manish.LLD.Parkinglot.exceptions.InvalidGateException;
import com.manish.LLD.Parkinglot.exceptions.NoAvailableSpotException;
import com.manish.LLD.Parkinglot.models.Ticket;
import com.manish.LLD.Parkinglot.models.VehicalType;
import com.manish.LLD.Parkinglot.services.TicketService;

public class TicketController {
//    public void generateTicket() {
//  Not a good idea as operator will have UI to call the controller so it better to put that in services
//    }

//    public Ticket generateTicket(Vehical vehical, Long gateId) {
//
//    }

    // To call the service now we have attributes of ticketService
    private TicketService ticketService;
    // Now we need to initialize it by using constructor and inject the dependencies(dependency injection)
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }


    public GenerateTicketResponseDto generateTicket(GenerateTicketRequestDto request) {
        // extracting the entities or parameter from request object
        String vehicleNumber = request.getVehicleNumber();
        VehicalType vehicalType = request.getVehicalType();
        Long gateId = request.getGateId();
        //after extracting the parameter from request
        //Now it will call the service -> So we need to have object of TicketService

//        Ticket ticket = ticketService.generateTicket(gateId, vehicalType, vehicleNumber);
//
//        GenerateTicketResponseDto response = new GenerateTicketResponseDto();

        Ticket ticket = new Ticket();
        GenerateTicketResponseDto response = new GenerateTicketResponseDto();

        try {
            ticket = ticketService.generateTicket(gateId, vehicalType, vehicleNumber);
        } catch (InvalidGateException e) {
            response.setResponseStatus(ResponseStatus.FAILURE);
            response.setMessage("Gate ID is invalid");
            return response;
        } catch (NoAvailableSpotException e) {
            response.setResponseStatus(ResponseStatus.SUCCESS);
            response.setMessage("No parking spot available");
            return response;
        }

        response.setResponseStatus(ResponseStatus.SUCCESS);
        response.setTicketId(ticket.getId());
        response.setOperatorName(ticket.getOperator().getName());
        response.setSpotNumber(ticket.getParkingSpot().getNumber());

        return response;
    }
}
