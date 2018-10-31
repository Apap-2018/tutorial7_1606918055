package com.apap.tutorial7.service;

import com.apap.tutorial7.model.FlightModel;
import com.apap.tutorial7.model.FlightStarter;
import com.apap.tutorial7.model.PilotModel;

import java.util.List;

public interface IFlightService {

    FlightModel addFlight(FlightModel flight);

    List<FlightModel> getAllFlight();

    Boolean addBulkFlight(FlightStarter flightStarter);

    FlightModel getFlightById(Long id);

    FlightModel getFlightByFlightNumber(String flightNumber);

    Boolean deleteFlightById(long id);

    FlightModel updateFlight(FlightModel flightModel);

    FlightModel updateFlightRest(FlightModel flightModel, String destination, String origin);

    FlightModel createFlightFactory(String licenseNumber);

    FlightStarter createFlightStarterFactory(String licenseNumber);
}
