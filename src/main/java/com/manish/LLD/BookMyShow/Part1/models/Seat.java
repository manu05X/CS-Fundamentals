package com.manish.LLD.BookMyShow.Part1.models;

import com.manish.LLD.BookMyShow.Part1.models.enums.SeatType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Seat {
    private String seatId;
    private CinemaHall cinemaHall;
    private int row;
    private int col;
    private SeatType type;
    private boolean isBooked; // Track if the seat is booked

    public Seat(String seatId, CinemaHall cinemaHall, int row, int col, SeatType seatType) {
        this.seatId = seatId;
        this.cinemaHall = cinemaHall;
        this.row = row;
        this.col = col;
        this.type = seatType;
        this.isBooked = false; // Initially, the seat is available
    }

    public void bookSeat() {
        this.isBooked = true;
    }

    public void cancelBooking() {
        this.isBooked = false;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "seatId='" + seatId + '\'' +
                ", cinemaHall=" + cinemaHall.getName() +
                ", row=" + row +
                ", col=" + col +
                ", type=" + type +
                ", isBooked=" + isBooked +
                '}';
    }
}
