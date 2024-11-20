package com.wipro.restapi.datajpa.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.wipro.restapi.datajpa.entity.Vehicle;
import com.wipro.restapi.datajpa.service.IVehicleService;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleRestController {
    @Autowired
    private IVehicleService service;

    @PostMapping("/add")
    public Vehicle add(@RequestBody Vehicle vehicle) {
        return service.addVehicle(vehicle);
    }

    @PutMapping("/update")
    public Vehicle update(@RequestBody Vehicle vehicle) {
        return service.updateVehicle(vehicle);
    }

    @GetMapping("/getbyid/{id}")
    public Vehicle getById(@PathVariable int id) {
        return service.getVehicleById(id);
    }

    @DeleteMapping("/deletebyid/{id}")
    public String deleteVehicleById(@PathVariable int id) {
        return service.deleteVehicleById(id);
    }

    @GetMapping("/getall")
    public List<Vehicle> getAllVehicles() {
        return service.getAllVehicles();
    }

    @GetMapping("/getbymodel/{model}")
    public Vehicle getByModel(@PathVariable String model) {
        return service.getByModel(model);
    }

    @GetMapping("/get-price-gt/{price}")
    public List<Vehicle> getByPriceGT(@PathVariable double price) {
        return service.getByPriceGT(price);
    }

    @GetMapping("/getsorted")
    public List<Vehicle> getBySortedPrice() {
        return service.getBySortedPrice();
    }
}
