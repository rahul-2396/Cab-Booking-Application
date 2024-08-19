package com.thinkify.cabbookingapp.dto.responsedto;

import com.thinkify.cabbookingapp.model.Location;
import lombok.Data;

@Data
public class BookRideResponseDto
{
    private Long bookingId;
    private UserResponseSignUpDto user;
    private DrivingPartnerResponseSignUpDto drivingPartner;
    private Location sourceLocation;
    private Location destinationLocation;
}

