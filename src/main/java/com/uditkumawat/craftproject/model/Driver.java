package com.uditkumawat.craftproject.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="drivers")
public class Driver implements Serializable {

    //primary key of table
    @Id
    @Column(name="driverId",nullable = false,unique = true)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 65)
    private String firstName;

    @NotNull
    @Size(max = 65)
    private String lastName;

    @NotNull
    @Email
    @Size(max = 100)
    @Column(unique = true)
    private String email;

    @NotNull
    @Size(max = 128)
    private String password;

    @NotNull
    @Embedded
    private Address address;

    @NotNull
    @Embedded
    private Vehicle vehicle;

    @NotNull
    @Size(max=15)
    private String phoneNumber;

    @Column(name="joined_date",nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime joinedDate;

    @NotBlank
    private String driverLicenceNumber;

    private int rating;

    private boolean documentsUploaded;

    private boolean isVerified;

    private boolean isActive;

    @OneToMany(mappedBy = "driver", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Document> documents;

    public Driver(){

    }

    public Driver(Long id, String firstName, String lastName, String email, String password, Address address, Vehicle vehicle, String phoneNumber, LocalDateTime joinedDate, String driverLicenceNumber, int rating, boolean documentsUploaded, boolean isVerified, boolean isActive, List<Document> documents) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.address = address;
        this.vehicle = vehicle;
        this.phoneNumber = phoneNumber;
        this.joinedDate = joinedDate;
        this.driverLicenceNumber = driverLicenceNumber;
        this.rating = rating;
        this.documentsUploaded = documentsUploaded;
        this.isVerified = isVerified;
        this.isActive = isActive;
        this.documents = documents;
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

    public LocalDateTime getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(LocalDateTime joinedDate) {
        this.joinedDate = joinedDate;
    }

    public String getDriverLicenceNumber() {
        return driverLicenceNumber;
    }

    public void setDriverLicenceNumber(String driverLicenceNumber) {
        this.driverLicenceNumber = driverLicenceNumber;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isDocumentsUploaded() {
        return documentsUploaded;
    }

    public void setDocumentsUploaded(boolean documentsUploaded) {
        this.documentsUploaded = documentsUploaded;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", address=" + address +
                ", vehicle=" + vehicle +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", joinedDate=" + joinedDate +
                ", driverLicenceNumber='" + driverLicenceNumber + '\'' +
                ", rating=" + rating +
                ", documentsUploaded=" + documentsUploaded +
                ", isVerified=" + isVerified +
                ", isActive=" + isActive +
                ", documents=" + documents +
                '}';
    }
}
