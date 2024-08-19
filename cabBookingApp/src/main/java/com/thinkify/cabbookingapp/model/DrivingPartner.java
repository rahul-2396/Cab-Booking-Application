package com.thinkify.cabbookingapp.model;

import lombok.Data;

import java.util.UUID;

@Data
public class DrivingPartner
{
    private String firstName;
    private String lastName;
    private String email;
    private Long id;
    private Vehicle vehicle;
    private Location location;
}


