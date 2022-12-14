package com.uditkumawat.craftproject.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Embeddable
public class Address{

    @Size(max=100)
    private String street;

    @Size(max=100)
    private String city;

    @Size(max=100)
    private String state;

    @Size(max=10)
    @Column(name="pin_code")
    private int pinCode;

    public Address(){}

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Address(String street, String city, String state, int pinCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.pinCode = pinCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", pinCode=" + pinCode +
                '}';
    }
}
