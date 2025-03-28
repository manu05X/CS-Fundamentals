package com.manish.LLD.BookMyShow.Part1.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class Movie {
    private String movieId;
    private String title;
    private String description;
    private int durationInMinutes;
    private String language;
    private double rating;
    private List<Genre> genreList;
    private LocalDate releaseDate; // ✅ Added Release Date


    // ✅ Add a constructor to initialize the movie object
    public Movie(String title, String language, List<Genre> genreList, int durationInMinutes, LocalDate releaseDate) {
        this.title = title;
        this.language = language;
        this.genreList = genreList;
        this.durationInMinutes = durationInMinutes;
        this.releaseDate = releaseDate;
        this.rating = 0.0;  // Default rating
    }
}
