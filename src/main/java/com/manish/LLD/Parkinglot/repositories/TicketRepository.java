package com.manish.LLD.Parkinglot.repositories;


import com.manish.LLD.Parkinglot.models.Ticket;

import java.util.Map;
import java.util.TreeMap;

public class TicketRepository {
//    public Ticket save(Ticket ticket) {
//        return null;
//    }
private Map<Long, Ticket> tickets = new TreeMap<>();
    // here we are using tree map because we also need to do range query , and treeMap have Log(n) TC
    // where as in hash map data is not sorted so range query such as -> Find id of all the gates from 1 to 10
    // so hash map will take TC O(n) and not O(1)
    private long lastSavedId = 0L;

    public Ticket save(Ticket ticket) {
        ticket.setId(lastSavedId + 1);
        lastSavedId += 1;
        tickets.put(lastSavedId, ticket);
        return ticket;
    }
}
