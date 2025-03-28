package com.manish.LLD.BookMyShow.Part2.repositories;

import com.manish.LLD.BookMyShow.Part2.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    Ticket save(Ticket ticket);
}
