package com.parking.parkinglot.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "parking_spot", unique = true)
    private String parking_spot;

    @Column(name = "license_plate", unique = true)
    private String license_plate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "owner")
    private User user;

    public String getParking_spot() {
        return parking_spot;
    }

    public void setParking_spot(String parking_spot) {
        this.parking_spot = parking_spot;
    }

    public String getLicense_plate() {
        return license_plate;
    }

    public void setLicense_plate(String license_plate) {
        this.license_plate = license_plate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}