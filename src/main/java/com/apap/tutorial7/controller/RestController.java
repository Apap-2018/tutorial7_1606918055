package com.apap.tutorial7.controller;

import com.apap.tutorial7.model.FlightModel;
import com.apap.tutorial7.service.IFlightService;
import com.apap.tutorial7.service.IPilotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/flight")
public class RestController {

    private final static Logger LOGGER = Logger.getLogger(RestController.class.getName());

    @Autowired
    private IFlightService flightService;

    @Autowired
    private IPilotService pilotService;

    @PostMapping("/add")
    public FlightModel createFlight(@RequestBody FlightModel flightModel) {
        return flightService.addFlight(flightModel);
    }

    @PutMapping("/update/{flightID}")
    public String updateFlight(@PathVariable("flightID") Long flightId,
                                    @RequestParam(value = "destination", required = false) String destination,
                                    @RequestParam(value = "origin", required = false) String origin) {
        FlightModel f = flightService.getFlightById(flightId);
        flightService.updateFlightRest(f, destination, origin);
        return "flight update success";
    }

    @GetMapping("/view/{flightNumber}")
    public FlightModel retrieveFlight(@PathVariable("flightNumber") String flightNumber) {
        return flightService.getFlightByFlightNumber(flightNumber);
    }

    @GetMapping("/view/all")
    public List<FlightModel> retrieveListFlight() {
        return flightService.getAllFlight();
    }
}
