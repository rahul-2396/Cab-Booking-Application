package com.thinkify.cabbookingapp.dto.requestdto;

import com.thinkify.cabbookingapp.model.Location;
import lombok.Data;

@Data
public class BookRideRequestDto
{
    private Long userID;
    private Long drivingPartnerID;
    private Location sourceLocation;
    private Location destinationLocation;
}
