package com.manish.LLD.BookMyShow.Part2.controllers;


import com.manish.LLD.BookMyShow.Part2.dtos.BookTicketRequestDto;
import com.manish.LLD.BookMyShow.Part2.dtos.BookTicketResponseDto;
import com.manish.LLD.BookMyShow.Part2.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TicketController {

    private TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public BookTicketResponseDto bookTicket(BookTicketRequestDto request) {
        BookTicketResponseDto response = new BookTicketResponseDto();

//        try {
////            ticketService.bookTicket()
//        } catch (TimeoutException e) {
//            response.setStatus("FAILURE");
//            response.setMessage("Something is wrong");
//        }

        return null;
    }
}
