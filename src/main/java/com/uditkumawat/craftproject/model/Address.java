package com.uditkumawat.craftproject.model;

import javax.persistence.*;

@Entity
@Table(name="address")
public class Address {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String city;
    private String state;
    private int pinCode;

    @Id
    public Long getId() {
        return id;
    }

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

    public void setId(Long id) {
        this.id = id;
    }
}
