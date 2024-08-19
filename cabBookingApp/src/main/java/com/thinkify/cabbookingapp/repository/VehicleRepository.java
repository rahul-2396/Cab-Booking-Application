package com.thinkify.cabbookingapp.repository;

import com.thinkify.cabbookingapp.model.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository
public class VehicleRepository {
    private HashMap<Long, Vehicle> vehicles = new HashMap<>();

    public List<Optional<Vehicle>> findByID(List<Long> vehicleID) {
        List<Optional<Vehicle>> vehiclesOptional = new ArrayList<>();
        for(Long id : vehicleID) {
            vehiclesOptional.add(Optional.of(vehicles.get(id)));
        }
        return  vehiclesOptional;
    }
}
