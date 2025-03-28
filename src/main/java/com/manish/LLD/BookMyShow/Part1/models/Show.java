package com.manish.LLD.BookMyShow.Part1.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class Show {
    private String showId;
    private Movie movie;
    private CinemaHall hall;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    private List<Seat> availableSeats; // Track available seats for the show

    public Show(String showId, Movie movie, CinemaHall hall, LocalDateTime startTime, LocalDateTime endTime, List<Seat> availableSeats) {
        this.showId = showId;
        this.movie = movie;
        this.hall = hall;
        this.startTime = startTime;
        this.endTime = endTime;
        this.availableSeats = availableSeats;
    }

    public List<Seat> getBookedSeats() {
        return availableSeats.stream()
                .filter(Seat::isBooked)
                .collect(Collectors.toList());
    }

    public List<Seat> getAvailableSeats() {
        return availableSeats.stream()
                .filter(seat -> !seat.isBooked())
                .collect(Collectors.toList());
    }


    @Override
    public String toString() {
        return "Show{" +
                "showId='" + showId + '\'' +
                ", movie=" + movie.getTitle() +
                ", hall=" + hall.getName() +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", availableSeats=" + availableSeats.size() +
                '}';
    }
}
