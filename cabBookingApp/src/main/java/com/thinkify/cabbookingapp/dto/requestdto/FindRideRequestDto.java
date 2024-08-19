package com.thinkify.cabbookingapp.dto.requestdto;

import lombok.Data;

@Data
public class FindRideRequestDto
{
    private int sourceLat;
    private int sourceLong;
    private int destinationLat;
    private int destinationLong;
}
