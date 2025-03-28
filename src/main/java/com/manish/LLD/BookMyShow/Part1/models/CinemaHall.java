package com.manish.LLD.BookMyShow.Part1.models;

import com.manish.LLD.BookMyShow.Part1.models.enums.SeatType;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CinemaHall {
    private Long hallId;
    private String name;
    private int totalRows;
    private int totalColumns;
    private Seat[][] seats;

    private List<Show> shows; // List of shows scheduled in this hall

    public CinemaHall(Long hallId, String name, int totalRows, int totalColumns) {
        this.hallId = hallId;
        this.name = name;
        this.totalRows = totalRows;
        this.totalColumns = totalColumns;
        this.seats = new Seat[totalRows][totalColumns];
        this.shows = new ArrayList<>();

        // Initialize seats in a 2D structure
        for (int row = 0; row < totalRows; row++) {
            for (int col = 0; col < totalColumns; col++) {
                String seatId = getSeatLabel(row, col); // Convert to "A10"
                seats[row][col] = new Seat(seatId, this, row, col, SeatType.NORMAL);
            }
        }
    }

    // Converts row=0, col=9 → "A10"
    private String getSeatLabel(int row, int col) {
        return (char) ('A' + row) + String.valueOf(col + 1);
    }

    public Seat getSeat(int row, int col) {
        if (row >= 0 && row < totalRows && col >= 0 && col < totalColumns) {
            return seats[row][col];
        } else {
            throw new IllegalArgumentException("Invalid seat coordinates: Row " + row + ", Col " + col);
        }
    }

    // Add a new show to the cinema hall
    public void addShow(Show show) {
        this.shows.add(show);
    }
}
