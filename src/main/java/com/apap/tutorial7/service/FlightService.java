package com.apap.tutorial7.service;

import com.apap.tutorial7.model.FlightModel;
import com.apap.tutorial7.model.FlightStarter;
import com.apap.tutorial7.model.PilotModel;
import com.apap.tutorial7.repository.FlightDB;
import com.apap.tutorial7.repository.PilotDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public FlightModel getFlightByFlightNumber(String flightNumber) {
        return flightDb.findByFlightNumber(flightNumber);
    }

    @Override
    public FlightModel addFlight(FlightModel flight) {
        return flightDb.save(flight);
    }

    @Override
    public List<FlightModel> getAllFlight() {
        return flightDb.findAll();
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
//        flightToUpdate.setPilotLicenseNumber(flightModel.getPilotLicenseNumber());

        flightDb.save(flightToUpdate);
        return flightToUpdate;
    }

    @Override
    public FlightModel updateFlightRest(FlightModel flightModel, String destination, String origin) {
        if(destination != null) {
            flightModel.setDestination(destination);
        }

        if(origin != null) {
            flightModel.setOrigin(origin);
        }
        return flightDb.save(flightModel);
    }

    @Override
    public FlightModel createFlightFactory(String licenseNumber) {
        PilotModel pilot = pilotDb.findByLicenseNumber(licenseNumber);
        FlightModel flight = new FlightModel();
        flight.setPilotLicenseNumber(pilot.getLicenseNumber());
        return flight;
    }

    @Override
    public FlightStarter createFlightStarterFactory(String licenseNumber) {
        return new FlightStarter(licenseNumber);
    }
}
