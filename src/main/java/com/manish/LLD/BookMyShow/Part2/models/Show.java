package com.manish.LLD.BookMyShow.Part2.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Show extends BaseModel{
    @ManyToOne
    private Auditorium auditorium;

    private Date startTime;

    private Date endTime;

    @ManyToOne
    private Movie movie;

    @Enumerated(EnumType.ORDINAL)
    private Language language;

}
