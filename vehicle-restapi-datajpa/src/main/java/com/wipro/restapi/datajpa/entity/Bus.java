package com.wipro.restapi.datajpa.entity;

import jakarta.persistence.Entity;

@Entity
public class Bus extends Vehicle {
    private int seatingCapacity;

    // Getters and Setters
    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    @Override
    public String toString() {
        return "Bus [seatingCapacity=" + seatingCapacity + ", " + super.toString() + "]";
    }
}
