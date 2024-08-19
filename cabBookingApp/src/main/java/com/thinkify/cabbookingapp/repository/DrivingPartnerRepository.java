package com.thinkify.cabbookingapp.repository;

import com.thinkify.cabbookingapp.dto.requestdto.DrivingPartnerRequestSignUpDto;
import com.thinkify.cabbookingapp.dto.responsedto.DrivingPartnerResponseSignUpDto;
import com.thinkify.cabbookingapp.dto.responsedto.VehicleResponseDto;
import com.thinkify.cabbookingapp.model.DrivingPartner;
import com.thinkify.cabbookingapp.model.Location;
import com.thinkify.cabbookingapp.model.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class DrivingPartnerRepository
{
    private Long vehicleId = 1L;
    private HashMap<Long, DrivingPartner> drivers = new HashMap<>();
    public void save(Long id, DrivingPartnerRequestSignUpDto drivingPartnerRequestSignUpDto) {
        DrivingPartner driver = new DrivingPartner();
        Vehicle vehicle = new Vehicle();
        vehicle.setId(vehicleId++);
        vehicle.setVehicleNumber(drivingPartnerRequestSignUpDto.getVehicle().getVehicleNumber());
        vehicle.setVehicleType(drivingPartnerRequestSignUpDto.getVehicle().getVehicleType());

        driver.setId(id);
        driver.setFirstName(drivingPartnerRequestSignUpDto.getFirstName());
        driver.setLastName(drivingPartnerRequestSignUpDto.getLastName());
        driver.setVehicle(vehicle);
        driver.setLocation(drivingPartnerRequestSignUpDto.getLocation());
        driver.setEmail(drivingPartnerRequestSignUpDto.getEmail());
        drivers.put(driver.getId(), driver);
    }

    public Optional<DrivingPartner> findDriver(Long id)
    {
        for(Map.Entry<Long, DrivingPartner> entry : drivers.entrySet()) {
            if(entry.getKey().equals(id)) {
                return Optional.of(entry.getValue());
            }
        }
        return Optional.empty();
    }
    public List<DrivingPartnerResponseSignUpDto> findAllDrivers() {
        List<DrivingPartnerResponseSignUpDto> driverList = new ArrayList<>();
        for(Map.Entry<Long, DrivingPartner> entry : drivers.entrySet()) {

            DrivingPartnerResponseSignUpDto drivingPartnerResponseSignUpDto = new DrivingPartnerResponseSignUpDto();
            DrivingPartner drivingPartner = drivers.get(entry.getKey());

            VehicleResponseDto vehicleResponseDto = new VehicleResponseDto();
            vehicleResponseDto.setId(drivingPartner.getVehicle().getId());
            vehicleResponseDto.setVehicleNumber(drivingPartner.getVehicle().getVehicleNumber());
            vehicleResponseDto.setVehicleType(drivingPartner.getVehicle().getVehicleType());
            Location location = new Location(drivingPartner.getLocation().getLatitude(),drivingPartner.getLocation().getLongitude());

            drivingPartnerResponseSignUpDto.setId(drivingPartner.getId());
            drivingPartnerResponseSignUpDto.setFirstName(drivingPartner.getFirstName());
            drivingPartnerResponseSignUpDto.setLastName(drivingPartner.getLastName());
            drivingPartnerResponseSignUpDto.setEmail(drivingPartner.getEmail());
            drivingPartnerResponseSignUpDto.setVehicle(vehicleResponseDto);
            drivingPartnerResponseSignUpDto.setLocation(location);

            driverList.add(drivingPartnerResponseSignUpDto);
        }
        return driverList;
    }
}
