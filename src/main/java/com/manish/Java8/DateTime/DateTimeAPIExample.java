package com.manish.Java8.DateTime;

import java.io.PrintStream;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeAPIExample {
    public DateTimeAPIExample() {
    }

    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        System.out.println("Current date: " + String.valueOf(currentDate));
        LocalTime currentTime = LocalTime.now();
        System.out.println("Current time: " + String.valueOf(currentTime));
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("Current date and time: " + String.valueOf(currentDateTime));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);
        System.out.println("Formatted current date and time: " + formattedDateTime);
        String dateString = "25-06-2024";
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate parsedDate = LocalDate.parse(dateString, dateFormatter);
        System.out.println("Parsed date: " + String.valueOf(parsedDate));
        ZonedDateTime currentZonedDateTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println("Current date and time in New York: " + String.valueOf(currentZonedDateTime));
        LocalDate startDate = LocalDate.of(2020, Month.JANUARY, 1);
        LocalDate endDate = LocalDate.of(2024, Month.JUNE, 25);
        Period period = Period.between(startDate, endDate);
        PrintStream var10000 = System.out;
        String var10001 = String.valueOf(startDate);
        var10000.println("Period between " + var10001 + " and " + String.valueOf(endDate) + ": " + period.getYears() + " years, " + period.getMonths() + " months, " + period.getDays() + " days");
        LocalTime startTime = LocalTime.of(9, 30);
        LocalTime endTime = LocalTime.of(17, 45);
        Duration duration = Duration.between(startTime, endTime);
        var10000 = System.out;
        var10001 = String.valueOf(startTime);
        var10000.println("Duration between " + var10001 + " and " + String.valueOf(endTime) + ": " + duration.toHours() + " hours, " + duration.toMinutesPart() + " minutes");
        Instant now = Instant.now();
        System.out.println("Current date and time in UTC: " + String.valueOf(now));
    }
}