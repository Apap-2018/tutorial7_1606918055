package com.apap.tutorial7.service;

import com.apap.tutorial7.model.PilotModel;
import com.apap.tutorial7.repository.PilotDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PilotService implements IPilotService {

    @Autowired
    private PilotDB pilotDb;

    @Override
    public PilotModel getPilotDetailByLicenseNumber(String licenseNumber) {
        return pilotDb.findByLicenseNumber(licenseNumber);
    }

    @Override
    public PilotModel getPilotById(Long id) {
        return pilotDb.getOne(id);
    }

    @Override
    public PilotModel addPilot(PilotModel pilot) {
        return pilotDb.save(pilot);
    }

    @Override
    public Boolean deletePilotById(long id) {
        pilotDb.deleteById(id);
        return true;
    }

    @Override
    public PilotModel updatePilot(PilotModel pilot) {
        PilotModel pilotToUpdate = pilotDb.getOne(pilot.getId());
        pilotToUpdate.setFlyHour(pilot.getFlyHour());
        pilotToUpdate.setLicenseNumber(pilot.getLicenseNumber());
        pilotToUpdate.setName(pilot.getName());

        pilotDb.save(pilotToUpdate);

        return pilotToUpdate;
    }

    public PilotDB getManager() {
        return pilotDb;
    }
}
