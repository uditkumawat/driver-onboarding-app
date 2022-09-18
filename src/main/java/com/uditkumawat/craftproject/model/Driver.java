package com.uditkumawat.craftproject.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="drivers")
public class Driver {

    //primary key of table
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Address address;
    private String phoneNumber;
    private Date joinedDate;
    private String driverLicenceNumber;
    private String currentVehicleId;
    private int rating;
    private String longitude;
    private String latitude;

    public Driver(){

    }
    public Driver(String firstName,String lastName,String email,Address address,String phoneNumber,String driverLicenceNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.driverLicenceNumber = driverLicenceNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="address_id",nullable = false)
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    public String getDriverLicenceNumber() {
        return driverLicenceNumber;
    }

    public void setDriverLicenceNumber(String driverLicenceNumber) {
        this.driverLicenceNumber = driverLicenceNumber;
    }

    public String getCurrentVehicleId() {
        return currentVehicleId;
    }

    public void setCurrentVehicleId(String currentVehicleId) {
        this.currentVehicleId = currentVehicleId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
