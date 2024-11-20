package com.wipro.restapi.datajpa.service;

import java.util.List;
import com.wipro.restapi.datajpa.entity.Vehicle;

public interface IVehicleService {
    Vehicle addVehicle(Vehicle vehicle);
    Vehicle updateVehicle(Vehicle vehicle);
    Vehicle getVehicleById(int id);
    String deleteVehicleById(int id);
    List<Vehicle> getAllVehicles();
    Vehicle getByModel(String model);
    List<Vehicle> getByPriceGT(double price);
    List<Vehicle> getBySortedPrice();
}
