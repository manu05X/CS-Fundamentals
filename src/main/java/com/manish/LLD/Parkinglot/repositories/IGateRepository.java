package com.manish.LLD.Parkinglot.repositories;



import com.manish.LLD.Parkinglot.models.Gate;

import java.util.Optional;

//In the interface we will put all the method that are needed by the services
public interface IGateRepository {
    Optional<Gate> findGateById(Long gateId);
}
