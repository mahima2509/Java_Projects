package com.wipro.restapi.datajpa.entity;

import jakarta.persistence.Entity;

@Entity
public class Car extends Vehicle {
    private int numberOfDoors;

    // Getters and Setters
    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public String toString() {
        return "Car [numberOfDoors=" + numberOfDoors + ", " + super.toString() + "]";
    }
}
