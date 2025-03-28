package com.manish.LLD.BookMyShow.Part1.services;

import com.manish.LLD.BookMyShow.Part1.models.Movie;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
@Getter
@Setter
public class MovieService {
    private List<Movie> movies;

    public List<Movie> searchMovies(String title, String language, String genre, LocalDate releaseDate, String city) {
        // Implementation
        return new ArrayList<>();
    }

    public void addMovie(Movie newMovie) {
        movies.add(newMovie);
    }
}

 */

@Getter
@Setter
public class MovieService {
    private List<Movie> movies;

    public MovieService() {
        this.movies = new ArrayList<>();
    }

    public List<Movie> searchMovies(String title, String language, String genre, LocalDate releaseDate, String city) {
        return movies.stream()
                .filter(movie -> (title == null || movie.getTitle().equalsIgnoreCase(title)))
                .filter(movie -> (language == null || movie.getLanguage().equalsIgnoreCase(language)))
                .filter(movie -> (genre == null || movie.getGenreList().stream()
                        .anyMatch(g -> g.getName().equalsIgnoreCase(genre))))
                .filter(movie -> (releaseDate == null || movie.getReleaseDate().equals(releaseDate)))
                .collect(Collectors.toList());
    }

    public void addMovie(Movie newMovie) {
        if (newMovie != null) {
            movies.add(newMovie);
        }
    }
}
