package com.apap.tutorial7.model;

import java.util.ArrayList;
import java.util.List;

public class FlightStarter {

    private List<FlightModel> flightRows;

    private String licenseNumber;

    public FlightStarter() {
        this(new ArrayList<>(), null);
    }

    public FlightStarter(String licenseNumber) {
        this(new ArrayList<>(), licenseNumber);
    }

    public FlightStarter(List<FlightModel> flightModelRows, String licenseNumber) {
        this.flightRows = flightModelRows;
        this.licenseNumber = licenseNumber;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public void add(FlightModel flightModel) {
        flightRows.add(flightModel);
    }

    public List<FlightModel> getFlightRows() {
        return flightRows;
    }

    public void clear() {
        clear(new ArrayList<>());
    }

    public void clear(List<FlightModel> list) {
        flightRows = list;
    }
}
