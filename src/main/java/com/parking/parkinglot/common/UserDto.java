package com.parking.parkinglot.common;

import com.parking.parkinglot.entities.Car;

import java.util.Set;

public class UserDto {
    Long id;
    Set<Car> cars;
    String username;
    String password;
    String email;

    public UserDto(Long id, Set<Car> cars, String username, String password, String email) {
        this.id = id;
        this.cars = cars;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
