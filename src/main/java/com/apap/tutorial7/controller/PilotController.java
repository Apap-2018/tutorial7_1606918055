package com.apap.tutorial7.controller;

import com.apap.tutorial7.model.PilotModel;
import com.apap.tutorial7.rest.PilotDetail;
import com.apap.tutorial7.rest.Setting;
import com.apap.tutorial7.service.IPilotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@RestController
@RequestMapping("/pilot")
public class PilotController {

    private final static Logger LOGGER = Logger.getLogger(PilotController.class.getName());

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private IPilotService pilotService;

    @Bean
    public RestTemplate rest() {
        return new RestTemplate();
    }

    @GetMapping("/status/{licenseNumber}")
    public String getStatus(@PathVariable("licenseNumber") String licenseNumber) throws Exception {
        String path = Setting.pilotUrl + "/pilot?licenseNumber=" + licenseNumber;
        return restTemplate.getForEntity(path, String.class).getBody();
    }

    @GetMapping("/full/{licenseNumber}")
    public PilotDetail postStatus(@PathVariable("licenseNumber") String licenseNumber) throws Exception {
        String path = Setting.pilotUrl + "/pilot";
        PilotModel pilotModel = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
        return restTemplate.postForObject(path, pilotModel, PilotDetail.class);
    }

    @PostMapping("/add")
    public PilotModel addPilotSubmit(@RequestBody PilotModel pilotModel) {
        return pilotService.addPilot(pilotModel);
    }

    @GetMapping("/view/{licenseNumber}")
    public PilotModel pilotView(@PathVariable("licenseNumber") String licenseNumber) {
        return pilotService.getPilotDetailByLicenseNumber(licenseNumber);
    }

    @DeleteMapping("/delete")
    public String deletePilot(@RequestParam("pilotId") Long pilotId) {
        pilotService.deletePilotById(pilotId);
        return "success";
    }

    @PutMapping("/update/{pilotId}")
    public String updatePilotSubmit(@PathVariable("pilotId") Long pilotId,
                                    @RequestParam("name") String name,
                                    @RequestParam("flyHour") Integer flyHour) {
        PilotModel pilotModel;
        try {
            pilotModel = pilotService.getPilotById(pilotId);
        } catch (Exception e) {
            return "Couldn't find your pilot";
        }

        pilotModel.setName(name);
        pilotModel.setFlyHour(flyHour);
        pilotService.updatePilot(pilotModel);
        return "update";
    }

}
