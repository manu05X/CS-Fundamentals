package com.manish.LLD.BookMyShow.Part1.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Cinema {
    private String cinemaId;
    private City city;
    private String name;
    private String address;
    private List<CinemaHall> halls;

    public Cinema(String cinemaId, City city, String name, String address) {
        this.cinemaId = cinemaId;
        this.city = city;
        this.name = name;
        this.address = address;
        this.halls = new ArrayList<>();
    }

    public void addHall(CinemaHall hall) {
        this.halls.add(hall);
    }
}
