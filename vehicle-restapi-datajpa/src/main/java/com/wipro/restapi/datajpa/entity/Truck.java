package com.wipro.restapi.datajpa.entity;

import jakarta.persistence.Entity;

@Entity
public class Truck extends Vehicle {
    private double loadCapacity;

    // Getters and Setters
    public double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    @Override
    public String toString() {
        return "Truck [loadCapacity=" + loadCapacity + ", " + super.toString() + "]";
    }
}
