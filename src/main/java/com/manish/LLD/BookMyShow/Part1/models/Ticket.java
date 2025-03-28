package com.manish.LLD.BookMyShow.Part1.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ticket {
    private String ticketId;
    private Show show;
    private Seat seat;
    private double price;
    private String userId;  // The user who booked this ticket

    public Ticket(String ticketId, Show show, Seat seat, double price, String userId) {
        this.ticketId = ticketId;
        this.show = show;
        this.seat = seat;
        this.price = price;
        this.userId = userId;
    }

    public Ticket() {

    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId='" + ticketId + '\'' +
                ", showId='" + show.getShowId() + '\'' +
                ", seat=" + seat +
                ", price=" + price +
                ", userId='" + userId + '\'' +
                '}';
    }
}

