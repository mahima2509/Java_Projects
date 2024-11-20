package com.wipro.restapi.datajpa.entity;

import jakarta.persistence.Entity;

@Entity
public class Motorcycle extends Vehicle {
    private boolean hasSidecar;

    // Getters and Setters
    public boolean isHasSidecar() {
        return hasSidecar;
    }

    public void setHasSidecar(boolean hasSidecar) {
        this.hasSidecar = hasSidecar;
    }

    @Override
    public String toString() {
        return "Motorcycle [hasSidecar=" + hasSidecar + ", " + super.toString() + "]";
    }
}
