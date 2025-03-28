package com.manish.LLD.BookMyShow.Part2.services;

import com.manish.LLD.BookMyShow.Part2.exceptions.InvalidArgumentsException;
import com.manish.LLD.BookMyShow.Part2.exceptions.SeatNotAvailableException;
import com.manish.LLD.BookMyShow.Part2.models.*;
import com.manish.LLD.BookMyShow.Part2.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    private final SeatRepository seatRepository;
    private final ShowSeatRepository showSeatRepository;
    private final ShowRepository showRepository;
    private final UserRepository userRepository;
    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(SeatRepository seatRepository,
                         ShowSeatRepository showSeatRepository,
                         ShowRepository showRepository,
                         UserRepository userRepository, TicketRepository ticketRepository) {
        this.seatRepository = seatRepository;
        this.showSeatRepository = showSeatRepository;
        this.showRepository = showRepository;
        this.userRepository = userRepository;
        this.ticketRepository = ticketRepository;
    }

    public Ticket bookTicket(List<Long> seatIds, Long showId, Long userId) throws InvalidArgumentsException, SeatNotAvailableException {
        // 1. for these seatIds get the correponding showseats getSeatsForIds(ids)
        // 2. Check the status of all the showseats getShowSeatsForSeats(seats)
        // 2.a: every seat is available (among selected for booking)
        //    i> : lock every seat (set the status to be locked)
        //   ii> : Create ticket obj and return it (may be to payment service or to client for proceeding further)
        // 2.b some of the seats are not available
        //    i> : throw an exception

        // 1. 1, 2, 5
        // 2. 2, 3, 5

        // getShowsForSeats()
        // set transavction isolation level serializable
        // start transaction;
        List<Seat> seats = seatRepository.findAllByIdIn(seatIds);
        Optional<Show> showOptional = showRepository.findById(showId);

        if (showOptional.isEmpty()){
            throw new InvalidArgumentsException(
                    "Show By: " +showId + " doesn't exist."
            );
        }

       /*

        List<ShowSeat> showSeats = showSeatRepository.findAllBySeatInAndShow(seats, showOptional.get());
        for (ShowSeat showSeat : showSeats) {
            if (!showSeat.getStatus().equals(ShowSeatStatus.AVAILABLE)){
                throw new SeatNotAvailableException(); // this exception will be caught by controller and they can send appropriate message to the users
            }
        }

        //Now required seats are available , so i should lock it
        for(ShowSeat showSeat : showSeats){
            showSeat.setStatus(ShowSeatStatus.LOCKED);
            showSeat.setLockedAt(new Date());
        }

        //now save the seat
        List<ShowSeat> savedShowSeats = new ArrayList<>();

        for (ShowSeat showSeat : showSeats) {
            showSeat.setStatus(ShowSeatStatus.LOCKED);
            showSeat.setLockedAt(new Date());
            savedShowSeats.add(showSeatRepository.save(showSeat));
        }
        */

        List<ShowSeat> showSeats = getAndLokcShowSeats(seats,showOptional);

        // now here we got the seat so create the ticket obj

        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isEmpty()){
            throw new InvalidArgumentsException("User By: " +userId + " doesn't exist.");
        }

        Ticket ticket = new Ticket();
        ticket.setBookedBy(userOptional.get());
        ticket.setTicketStatus(TicketStatus.PROCESSING);
        ticket.setShow(showOptional.get());
        ticket.setSeats(seats);
        ticket.setAmount(0);
        ticket.setTimeOfBooking(new Date());

        Ticket saveTicket = ticketRepository.save(ticket);

        return saveTicket;

        //List<ShowSeat> showSeats = getAndLokcShowSeats(seats,showOptional.get());
        //Optional<User> userOptional = userRepository.findById(userId);


       // return null;

    }

    @Transactional(isolation = Isolation.SERIALIZABLE, timeout = 2)
    public List<ShowSeat> getAndLokcShowSeats(List<Seat> seats, Optional<Show> showOptional) throws SeatNotAvailableException {
        List<ShowSeat> showSeats = showSeatRepository.findAllBySeatInAndShow(seats, showOptional.get());

        for (ShowSeat showSeat: showSeats) {
            if (!(showSeat.getStatus().equals(ShowSeatStatus.AVAILABLE) || (
                    showSeat.getStatus().equals(ShowSeatStatus.LOCKED)))) { // && new Date( - showSeat.getLockedAt())))) {
                throw new SeatNotAvailableException();
            }
        }

        List<ShowSeat> savedShowSeats = new ArrayList<>();

        for (ShowSeat showSeat: showSeats) {
            showSeat.setStatus(ShowSeatStatus.LOCKED);
            showSeat.setLockedAt(new Date());
            savedShowSeats.add(showSeatRepository.save(showSeat));
        }


        return showSeats;
    }
}
