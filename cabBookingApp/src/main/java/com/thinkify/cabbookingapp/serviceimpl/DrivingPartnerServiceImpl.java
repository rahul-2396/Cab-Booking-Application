package com.thinkify.cabbookingapp.serviceimpl;

import com.thinkify.cabbookingapp.dto.requestdto.DrivingPartnerRequestSignUpDto;
import com.thinkify.cabbookingapp.dto.responsedto.DrivingPartnerResponseSignUpDto;
import com.thinkify.cabbookingapp.dto.responsedto.VehicleResponseDto;
import com.thinkify.cabbookingapp.exception.DriverNotFoundException;
import com.thinkify.cabbookingapp.model.DrivingPartner;
import com.thinkify.cabbookingapp.model.Location;
import com.thinkify.cabbookingapp.repository.DrivingPartnerRepository;
import com.thinkify.cabbookingapp.service.DrivingPartnerService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DrivingPartnerServiceImpl implements DrivingPartnerService {

    private Long id = 1L;
    private DrivingPartnerRepository drivingPartnerRepository;

    public DrivingPartnerServiceImpl(DrivingPartnerRepository drivingPartnerRepository) {
        this.drivingPartnerRepository = drivingPartnerRepository;
    }

    @Override
    public Long addDriver(DrivingPartnerRequestSignUpDto drivingPartnerRequestSignUpDto) {
        drivingPartnerRepository.save(id,drivingPartnerRequestSignUpDto);
        return id++;
    }

    @Override
    public DrivingPartnerResponseSignUpDto findDrivingPartnerByID(Long id) throws DriverNotFoundException {


        Optional<DrivingPartner> drivingPartnerOptional = drivingPartnerRepository.findDriver(id);
        if(drivingPartnerOptional.isEmpty()) {
            throw new DriverNotFoundException("Driver Not Found");
        }

        DrivingPartnerResponseSignUpDto drivingPartnerResponseSignUpDto = new DrivingPartnerResponseSignUpDto();
        DrivingPartner drivingPartner = drivingPartnerOptional.get();
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
        return drivingPartnerResponseSignUpDto;
    }
}
