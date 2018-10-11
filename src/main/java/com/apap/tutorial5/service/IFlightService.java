package com.apap.tutorial5.service;

import com.apap.tutorial5.model.FlightModel;
import com.apap.tutorial5.model.FlightStarter;
import com.apap.tutorial5.model.PilotModel;

public interface IFlightService {

    Boolean addFlight(FlightModel flight);

    Boolean addBulkFlight(FlightStarter flightStarter);

    FlightModel getFlightById(Long id);

    Boolean deleteFlightById(long id);

    FlightModel updateFlight(FlightModel flightModel);

    FlightModel createFlightFactory(String licenseNumber);

    FlightStarter createFlightStarterFactory(String licenseNumber);
}
