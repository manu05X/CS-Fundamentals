package com.manish.LLD.BookMyShow.Part2.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Seat extends BaseModel {
    private String seatNumber;
    //as it conflicts naming convention in sql so we save it as rowz and colz to bypass conflict
    @Column(name = "rowz")
    private int row;
    @Column(name = "colz")
    private int col;

    @ManyToOne
    private SeatType seatType; //S -> ST 1 : 1 // ST -> S  1 : M   so S : ST is M : 1
}
