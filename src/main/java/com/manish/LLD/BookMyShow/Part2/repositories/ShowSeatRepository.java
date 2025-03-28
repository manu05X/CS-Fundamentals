package com.manish.LLD.BookMyShow.Part2.repositories;

import com.manish.LLD.BookMyShow.Part2.models.Seat;
import com.manish.LLD.BookMyShow.Part2.models.Show;
import com.manish.LLD.BookMyShow.Part2.models.ShowSeat;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {
    //    @Query("select * from shows where startTime FOR UPDATE")
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    List<ShowSeat> findAllBySeatInAndShow(List<Seat> seats, Show show);

    //showSeat handle both for update and save operation, they are diff in sense
    // that if showSeat have id then update else only save operation
    ShowSeat save(ShowSeat showSeat);
}
