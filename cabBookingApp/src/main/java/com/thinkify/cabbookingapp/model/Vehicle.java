package com.thinkify.cabbookingapp.model;

import com.thinkify.cabbookingapp.enums.VehicleType;
import lombok.Data;

import java.util.UUID;

@Data
public class Vehicle
{
    private Long id;
    private String vehicleNumber;
    private VehicleType vehicleType;
}


