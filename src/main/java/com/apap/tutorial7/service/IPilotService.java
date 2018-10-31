package com.apap.tutorial7.service;

import com.apap.tutorial7.model.PilotModel;

public interface IPilotService {

    PilotModel getPilotDetailByLicenseNumber(String licenseNumber);

    PilotModel getPilotById(Long id);

    PilotModel addPilot(PilotModel pilot);

    Boolean deletePilotById(long id);

    PilotModel updatePilot(PilotModel pilot);

}
