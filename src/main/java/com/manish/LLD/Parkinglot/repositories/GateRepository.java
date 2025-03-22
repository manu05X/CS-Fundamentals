package com.manish.LLD.Parkinglot.repositories;



import com.manish.LLD.Parkinglot.models.Gate;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

/*
Have every method allows to do CRUD operations on gate on DB
 */
public class GateRepository implements IGateRepository {
//    public Gate findGateById(Long gateId) {
//        return null;
//    }
    /*
    we may forget to check for null in our TicketService while using findGateById so our code
    may get into a NULL POINTER exception at runtime so we use Optional to avoid it as it is handled by
    optional.

         Optional<Gate>
         Google: CPP
    */
    private Map<Long, Gate> gates = new TreeMap<>();
    // here we are using tree map because we also need to do range query , and treeMap have Log(n) TC
    // where as in hash map data is not sorted so range query such as -> Find id of all the gates from 1 to 10
    // so hash map will take TC O(n) and not O(1)

    //returning a gate using gateId
    public Optional<Gate> findGateById(Long gateId) {
        if (gates.containsKey(gateId)) {
            return Optional.of(gates.get(gateId));
        }
        return Optional.empty();
    }
}


