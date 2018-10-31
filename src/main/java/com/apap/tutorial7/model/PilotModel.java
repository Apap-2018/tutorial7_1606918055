package com.apap.tutorial7.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "pilot")
public class PilotModel extends AbstractEntity implements Serializable {

    @NotNull
    @Size(max = 50)
    @Column(name = "license_number", nullable = false, unique = true)
    private String licenseNumber;

    @NotNull
    @Size(max = 50)
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "fly_hour", nullable = false)
    private int flyHour;

    @OneToMany(mappedBy = "pilotLicenseNumber", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<FlightModel> pilotFlights;

    public PilotModel() {
    }

    public PilotModel(@NotNull @Size(max = 50) String licenseNumber, @NotNull @Size(max = 50) String name, @NotNull int flyHour) {
        this.licenseNumber = licenseNumber;
        this.name = name;
        this.flyHour = flyHour;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFlyHour() {
        return flyHour;
    }

    public void setFlyHour(int flyHour) {
        this.flyHour = flyHour;
    }

    public List<FlightModel> getPilotFlights() {
        return pilotFlights;
    }

    public void setPilotFlights(List<FlightModel> pilotFlights) {
        this.pilotFlights = pilotFlights;
    }

    @Override
    public String toString() {
        return "PilotModel{" +
                "id=" + getId() + '\'' +
                "licenseNumber='" + licenseNumber + '\'' +
                ", name='" + name + '\'' +
                ", flyHour=" + flyHour +
                ", pilotFlights=" + pilotFlights +
                '}';
    }
}
