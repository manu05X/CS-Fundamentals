package com.manish.LLD.BookMyShow.Part1;

import com.manish.LLD.BookMyShow.Part1.models.*;
import com.manish.LLD.BookMyShow.Part1.models.enums.PaymentMethod;
import com.manish.LLD.BookMyShow.Part1.services.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Initialize services
        MovieService movieService = new MovieService();
        CinemaService cinemaService = new CinemaService();
        BookingService bookingService = new BookingService();
        PaymentService paymentService = new PaymentService();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWelcome to BookMyShow!");
            System.out.println("1. Add a new movie");
            System.out.println("2. Search and book a movie");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 1) {
                // Add a new movie
                System.out.print("Enter movie title: ");
                String title = scanner.nextLine();

                System.out.print("Enter language: ");
                String language = scanner.nextLine();

                System.out.print("Enter genre: ");
                String genreInput = scanner.nextLine();
                List<Genre> genres = Arrays.stream(genreInput.split(","))
                        .map(Genre::new)  // Assuming Genre class has a constructor Genre(String name)
                        .collect(Collectors.toList());

                System.out.print("Enter duration (in minutes): ");
                int duration = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                System.out.print("Enter release year (YYYY-MM-DD): ");
                String releaseDateInput = scanner.nextLine();
                LocalDate releaseDate = LocalDate.parse(releaseDateInput);

                Movie newMovie = new Movie(title, language, genres, duration, releaseDate);
                movieService.addMovie(newMovie);

                System.out.println("Movie added successfully!\n");

            } else if (choice == 2) {
                // Booking process
                System.out.print("Enter city name: ");
                String cityName = scanner.nextLine();

                System.out.print("Enter movie title: ");
                String movieTitle = scanner.nextLine();

                // Search movies
                List<Movie> movies = movieService.searchMovies(movieTitle, null, null, null, cityName);

                if (movies.isEmpty()) {
                    System.out.println("No movies found!");
                    continue;
                }

                Movie selectedMovie = movies.get(0);
                System.out.println("Selected movie: " + selectedMovie.getTitle());

                // Get shows for this movie
                List<Show> shows = cinemaService.getShowsForMovieInCity(selectedMovie.getMovieId(), cityName);

                if (shows.isEmpty()) {
                    System.out.println("No shows available!");
                    continue;
                }

                Show selectedShow = shows.get(0);
                System.out.println("Selected show at: " + selectedShow.getStartTime());

                // Display available seats (simplified)
                System.out.println("Available seats: A1, A2, A3, B1, B2");

                System.out.print("Enter seats to book (comma separated): ");
                String seatsInput = scanner.nextLine();

                // Create booking
                User user = new User("user1", "John Doe", "john@example.com", "1234567890");
                List<Seat> selectedSeats = new ArrayList<>(); // Should be populated from input
                Booking booking = bookingService.createBooking(user, selectedShow, selectedSeats, null);

                // Process payment
                System.out.println("Total amount: " + booking.calculateTotalAmount());
                System.out.print("Select payment method (1. Credit Card, 2. Debit Card, 3. Cash): ");
                int paymentChoice = scanner.nextInt();

                PaymentMethod method = paymentChoice == 1 ? PaymentMethod.CREDIT_CARD :
                        paymentChoice == 2 ? PaymentMethod.DEBIT_CARD : PaymentMethod.CASH;

                boolean paymentSuccess = paymentService.processPayment(booking, method);

                if (paymentSuccess) {
                    System.out.println("Booking confirmed! Enjoy your movie.");
                } else {
                    System.out.println("Payment failed. Please try again.");
                }

            } else if (choice == 3) {
                System.out.println("Thank you for using BookMyShow. Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
