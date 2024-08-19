package com.thinkify.cabbookingapp.service;

import com.thinkify.cabbookingapp.dto.requestdto.DrivingPartnerRequestSignUpDto;
import com.thinkify.cabbookingapp.dto.responsedto.DrivingPartnerResponseSignUpDto;
import com.thinkify.cabbookingapp.exception.DriverNotFoundException;

public interface DrivingPartnerService
{
    Long addDriver(DrivingPartnerRequestSignUpDto drivingPartnerRequestSignUpDto);

    DrivingPartnerResponseSignUpDto findDrivingPartnerByID(Long id) throws DriverNotFoundException;
}
