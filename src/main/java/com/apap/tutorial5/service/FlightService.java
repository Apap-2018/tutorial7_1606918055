package com.apap.tutorial5.service;

import com.apap.tutorial5.model.FlightModel;
import com.apap.tutorial5.model.FlightStarter;
import com.apap.tutorial5.model.PilotModel;
import com.apap.tutorial5.repository.FlightDB;
import com.apap.tutorial5.repository.PilotDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@Transactional
public class FlightService implements IFlightService {

    @Autowired
    private FlightDB flightDb;

    @Autowired
    private PilotDB pilotDb;

    @Override
    public FlightModel getFlightById(Long id) {
        return flightDb.getOne(id);
    }

    @Override
    public Boolean addFlight(FlightModel flight) {
        flightDb.save(flight);
        return true;
    }

    @Override
    public Boolean addBulkFlight(FlightStarter flightStarter) {
        try {
            for(FlightModel flight : flightStarter.getFlightRows()) addFlight(flight);
        } catch(Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public Boolean deleteFlightById(long id) {
        flightDb.deleteById(id);
        return true;
    }

    @Override
    public FlightModel updateFlight(FlightModel flightModel) {
        FlightModel flightToUpdate = flightDb.getOne(flightModel.getId());
        flightToUpdate.setDestination(flightModel.getDestination());
        flightToUpdate.setFlightNumber(flightModel.getFlightNumber());
        flightToUpdate.setOrigin(flightModel.getOrigin());
        flightToUpdate.setTime(flightModel.getTime());
//        flightToUpdate.setPilot(flightModel.getPilot());

        flightDb.save(flightToUpdate);
        return flightToUpdate;
    }

    @Override
    public FlightModel createFlightFactory(String licenseNumber) {
        PilotModel pilot = pilotDb.findByLicenseNumber(licenseNumber);
        FlightModel flight = new FlightModel();
        flight.setPilot(pilot);
        return flight;
    }

    @Override
    public FlightStarter createFlightStarterFactory(String licenseNumber) {
        return new FlightStarter(licenseNumber);
    }
}
