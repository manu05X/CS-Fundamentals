package com.manish.LLD.BookMyShow.Part1.services;

import com.manish.LLD.BookMyShow.Part1.models.*;
import com.manish.LLD.BookMyShow.Part1.models.enums.BookingStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/*
public class BookingService {
    private List<Booking> bookings;

    public Booking createBooking(User user, Show show, List<Seat> seats, DiscountCoupon coupon) {
        // Implementation
        return null;
    }

    public boolean cancelBooking(String bookingId) {
        // Implementation
        return false;
    }
}

 */

public class BookingService {
    private List<Booking> bookings;

    public BookingService() {
        this.bookings = new ArrayList<>();
    }

    /**
     * Creates a new booking for the user if seats are available.
     */
    public Booking createBooking(User user, Show show, List<Seat> selectedSeats, DiscountCoupon coupon) {
        // Validate that seats are available
        if (!areSeatsAvailable(show, selectedSeats)) {
            System.out.println("Some selected seats are already booked.");
            return null; // Booking failed
        }

        // Mark seats as booked
        bookSeats(show, selectedSeats);

        // Create a new booking object
        Booking booking = new Booking();
        booking.setBookingId(UUID.randomUUID().toString());
        booking.setUser(user);
        booking.setShow(show);
        booking.setBookingTime(LocalDateTime.now());
        booking.setStatus(BookingStatus.CONFIRMED);
        booking.setTickets(generateTickets(selectedSeats, show));
        booking.setCoupon(coupon);

        // Add to the booking list
        bookings.add(booking);

        return booking;
    }

    /**
     * Cancels a booking and releases seats.
     */
    public boolean cancelBooking(String bookingId) {
        Optional<Booking> bookingOpt = bookings.stream()
                .filter(b -> b.getBookingId().equals(bookingId))
                .findFirst();

        if (bookingOpt.isPresent()) {
            Booking booking = bookingOpt.get();
            booking.setStatus(BookingStatus.CANCELLED);
            releaseSeats(booking.getShow(), booking.getTickets());
            return true;
        }
        return false;
    }

    /**
     * Checks if all selected seats are available for booking.
     */
    private boolean areSeatsAvailable(Show show, List<Seat> selectedSeats) {
        return selectedSeats.stream().allMatch(seat -> !isSeatBooked(show, seat));
    }

    /**
     * Marks the given seats as booked in the system.
     */
    private void bookSeats(Show show, List<Seat> selectedSeats) {
        for (Seat seat : selectedSeats) {
            show.getBookedSeats().add(seat);
        }
    }

    /**
     * Releases seats when a booking is canceled.
     */
    private void releaseSeats(Show show, List<Ticket> tickets) {
        for (Ticket ticket : tickets) {
            show.getBookedSeats().remove(ticket.getSeat());
        }
    }

    /**
     * Checks if a seat is already booked for the given show.
     */
    private boolean isSeatBooked(Show show, Seat seat) {
        return show.getBookedSeats().contains(seat);
    }

    /**
     * Generates tickets for selected seats.
     */
    private List<Ticket> generateTickets(List<Seat> seats, Show show) {
        List<Ticket> tickets = new ArrayList<>();
        for (Seat seat : seats) {
            Ticket ticket = new Ticket();
            ticket.setTicketId(UUID.randomUUID().toString());
            ticket.setShow(show);
            ticket.setSeat(seat);
            ticket.setPrice(100.0); // Assume a fixed price for now
            tickets.add(ticket);
        }
        return tickets;
    }
}
