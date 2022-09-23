package com.uditkumawat.craftproject.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Embeddable
public class Vehicle implements Serializable {

    @Size(max=4)
    private int year;

    @NotNull
    private String make;

    @NotNull
    private String model;

    @NotNull
    private String vehicleNumber;

    @NotNull
    private VehicleType vehicleType;

    @NotNull
    private String color;

    @NotNull
    private String insuranceNumber;

    public Vehicle(int year, String make, String model, String vehicleNumber, VehicleType vehicleType, String color, String insuranceNumber) {
        this.year = year;
        this.make = make;
        this.model = model;
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.color = color;
        this.insuranceNumber = insuranceNumber;
    }

    public Vehicle(){}

    @Override
    public String toString() {
        return "Vehicle{" +
                "year=" + year +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", vehicleNumber='" + vehicleNumber + '\'' +
                ", vehicleType=" + vehicleType +
                ", color='" + color + '\'' +
                ", insuranceNumber='" + insuranceNumber + '\'' +
                '}';
    }
}
