package com.uditkumawat.craftproject.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name="addresses")
public class Address {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Size(max=100)
    private String city;
    @Size(max=100)
    private String state;
    @Size(max=10)
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
