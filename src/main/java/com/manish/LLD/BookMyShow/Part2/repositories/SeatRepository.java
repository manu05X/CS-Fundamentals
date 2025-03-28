package com.manish.LLD.BookMyShow.Part2.repositories;

import com.manish.LLD.BookMyShow.Part2.models.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// here JpaRepository<Seat, Long> long reflects the datatype of primary key of seat
@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findAllByIdIn(List<Long> seatIds);

    //Jpa will convert the above english into SQL query to get desired data from DB
    // select *
    // from seats
    // where id = {}
    // and col = {}
}
