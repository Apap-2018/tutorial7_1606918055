package com.apap.tutorial7.repository;

import com.apap.tutorial7.model.FlightModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightDB extends JpaRepository<FlightModel, Long> {

    FlightModel findByFlightNumber(String flightNumber);
}
