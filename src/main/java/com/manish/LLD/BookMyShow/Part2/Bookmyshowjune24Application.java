package com.manish.LLD.BookMyShow.Part2;


import com.manish.LLD.BookMyShow.Part2.controllers.UserController;
import com.manish.LLD.BookMyShow.Part2.dtos.SignUpUserRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Bookmyshowjune24Application implements CommandLineRunner {

    private UserController userController;

    @Autowired
    public Bookmyshowjune24Application(UserController userController) {
        this.userController = userController;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello");

        SignUpUserRequestDto request = new SignUpUserRequestDto();
        request.setEmail("manish@scaler.com");
        request.setPassword("password");

        userController.signUpUser(request);
    }

    public static void main(String[] args) {

        SpringApplication.run(Bookmyshowjune24Application.class, args);
    }

}

//https://github.com/Naman-Bhalla/bookmyshowjune231

/*


_______________
Auditorium.java
BaseModel.java
City.java
Feature.java
Language.java
Movie.java
Payment.java
PaymentProvider.java
PaymentStatus.java
PaymentType.java
Seat.java
SeatType.java
Show.java
ShowSeat.java
ShowSeatStatus.java
ShowSeatType.java
Theatre.java
Ticket.java
TicketStatus.java
User.java
* */