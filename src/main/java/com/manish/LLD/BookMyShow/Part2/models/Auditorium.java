package com.manish.LLD.BookMyShow.Part2.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Auditorium extends BaseModel{
    private String name;
    @OneToMany
    private List<Seat> seats;

    @Enumerated(EnumType.STRING)
    @ElementCollection // element collections of enum, way to suggest that it's a collection of ENUM
    private List<Feature> features;
//    @OneToMany
//    private List<Show> shows; // List of show available for booking
//    @OneToOne
//    private Show show; // current running show

}
