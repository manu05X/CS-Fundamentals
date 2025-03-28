package com.manish.LLD.BookMyShow.Part1.services;

import com.manish.LLD.BookMyShow.Part1.models.Cinema;
import com.manish.LLD.BookMyShow.Part1.models.Show;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
public class CinemaService {
    private List<Cinema> cinemas;

    public List<Cinema> getCinemasByCity(String cityId) {
        // Implementation
        return new ArrayList<>();
    }

    public List<Show> getShowsForMovieInCity(String movieId, String cityId) {
        // Implementation
        return new ArrayList<>();
    }
}

 */


public class CinemaService {
    private List<Cinema> cinemas; // List of all cinemas

    public CinemaService() {
        this.cinemas = new ArrayList<>(); // Initialize with an empty list
    }

    // Add a cinema to the list
    public void addCinema(Cinema cinema) {
        cinemas.add(cinema);
    }

    // Get all cinemas in a given city
    public List<Cinema> getCinemasByCity(String cityId) {
        return cinemas.stream()
                .filter(cinema -> cinema.getCity().getCityId().equals(cityId))
                .collect(Collectors.toList());
    }

    // Get all shows for a given movie in a specific city
    public List<Show> getShowsForMovieInCity(String movieId, String cityId) {
        return cinemas.stream()
                .filter(cinema -> cinema.getCity().getCityId().equals(cityId))
                .flatMap(cinema -> cinema.getHalls().stream())  // Get all cinema halls
                .flatMap(hall -> hall.getShows().stream())       // Get all shows in those halls
                .filter(show -> show.getMovie().getMovieId().equals(movieId))
                .collect(Collectors.toList());
    }
}