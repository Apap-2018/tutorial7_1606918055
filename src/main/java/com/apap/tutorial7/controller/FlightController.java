package com.apap.tutorial7.controller;

import com.apap.tutorial7.model.FlightModel;
import com.apap.tutorial7.model.FlightStarter;
import com.apap.tutorial7.model.PilotModel;
import com.apap.tutorial7.service.IFlightService;
import com.apap.tutorial7.service.IPilotService;
import com.apap.tutorial7.service.PilotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * https://github.com/thymeleaf/thymeleafexamples-stsm/blob/3.0-master/src/main/webapp/WEB-INF/templates/seedstartermng.html
 * https://github.com/thymeleaf/thymeleafexamples-stsm/blob/3.0-master/src/main/java/thymeleafexamples/stsm/web/controller/SeedStarterMngController.java
 * https://www.thymeleaf.org/doc/tutorials/3.0/thymeleafspring.html#dynamic-fields
 */
@Controller
public class FlightController {

    private final static Logger LOGGER = Logger.getLogger(FlightController.class.getName());

    @Autowired
    private IFlightService flightService;

    @Autowired
    private IPilotService pilotService;

//    @RequestMapping(value = "/flight/add/{licenseNumber}", method = RequestMethod.GET)
//    private String add(@PathVariable(value = "licenseNumber") String licenseNumber, Model model) {
//        FlightStarter flightStarter = flightService.createFlightStarterFactory(licenseNumber);
//        flightStarter.add(flightService.createFlightFactory(licenseNumber));
//
//        model.addAttribute("flightStarter", flightStarter);
//        return "addFlight";
//    }
//
//    @RequestMapping(value = "/flight/add/{licenseNumber}", method = RequestMethod.POST, params = {"save"})
//    private String saveFlights(@PathVariable(value = "licenseNumber") String licenseNumber, @ModelAttribute FlightStarter flightStarter, BindingResult bindingResult) {
//        if(bindingResult.hasErrors()) {
//            return "addFlight";
//        }
//        LOGGER.log(Level.WARNING, flightStarter.getFlightRows().toString());
//        boolean success = flightService.addBulkFlight(flightStarter);
//
//        if(!success) return "addFlight";
//        return "add";
//    }
//
//    @RequestMapping(value = "/flight/add/{licenseNumber}", method = RequestMethod.POST, params = {"addRow"})
//    private String addRow(@PathVariable(value = "licenseNumber") String licenseNumber, @ModelAttribute FlightStarter flightStarter, BindingResult bindingResult) {
//        // we put bindingResult here to override server field check
//        flightStarter.add(flightService.createFlightFactory(licenseNumber));
//        return "addFlight";
//    }
//
//    @RequestMapping(value = "/flight/view/{id}", method = RequestMethod.GET)
//    private String viewFlight(@PathVariable(value = "id") Long id, Model model) {
//        FlightModel flight = flightService.getFlightById(id);
//        model.addAttribute("flight", flight);
//        return "view-flight";
//    }
//
//    @RequestMapping(value = "/flight/delete", method = RequestMethod.POST)
//    private String deleteFlight(@ModelAttribute PilotModel pilot) {
//        for(FlightModel flight : pilot.getPilotFlights()) {
//            flightService.deleteFlightById(flight.getId());
//        }
//
//        return "delete";
//    }
//
//    @RequestMapping(value = "/flight/update/{id}", method = RequestMethod.GET)
//    private String updateFlight(@PathVariable(value = "id") Long id, Model model) {
//        FlightModel flight = flightService.getFlightById(id);
//        model.addAttribute("flight", flight);
//        model.addAttribute("pilots", ((PilotService) pilotService).getManager().findAll());
//        return "updateFlight";
//    }
//
//    @RequestMapping(value = "/flight/update/{id}", method = RequestMethod.POST)
//    private String updateSubmitFlight(@PathVariable(value = "id") Long id, @ModelAttribute FlightModel flight) {
//        flight.setId(id);
//        LOGGER.log(Level.INFO, "Flight Id: " + flight.toString());
//        flightService.updateFlight(flight);
//        return "redirect:/flight/view/" + id;
//    }
}
