package com.wipro.restapi.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.wipro.restapi.datajpa.entity.Vehicle;
import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
    Vehicle findByModel(String model);
    List<Vehicle> findByPriceGreaterThan(double price);
    List<Vehicle> findAllByOrderByPriceAsc();
}
