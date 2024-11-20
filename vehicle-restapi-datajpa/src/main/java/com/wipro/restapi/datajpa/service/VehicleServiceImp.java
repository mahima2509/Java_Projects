package com.wipro.restapi.datajpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wipro.restapi.datajpa.entity.Vehicle;
import com.wipro.restapi.datajpa.repository.VehicleRepository;
import java.util.List;

@Service
public class VehicleServiceImp implements IVehicleService {
    @Autowired
    private VehicleRepository repo;

    @Override
    public Vehicle addVehicle(Vehicle vehicle) {
        return repo.save(vehicle);
    }

    @Override
    public Vehicle updateVehicle(Vehicle vehicle) {
        return repo.save(vehicle);
    }

    @Override
    public Vehicle getVehicleById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public String deleteVehicleById(int id) {
        repo.deleteById(id);
        return "Record deleted for ID " + id;
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return repo.findAll();
    }

    @Override
    public Vehicle getByModel(String model) {
        return repo.findByModel(model);
    }

    @Override
    public List<Vehicle> getByPriceGT(double price) {
        return repo.findByPriceGreaterThan(price);
    }

    @Override
    public List<Vehicle> getBySortedPrice() {
        return repo.findAllByOrderByPriceAsc();
    }
}
