package com.thinkify.cabbookingapp.model;

import lombok.Data;

import java.util.UUID;

@Data
public class Ride
{
    private Long id;
    private Long userId;
    private Long drivingPartnerId;
    private Location sourceLocation;
    private Location destinationLocation;
}
