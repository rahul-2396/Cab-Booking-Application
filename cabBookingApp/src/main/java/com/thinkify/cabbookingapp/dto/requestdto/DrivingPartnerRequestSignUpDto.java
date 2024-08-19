package com.thinkify.cabbookingapp.dto.requestdto;

import com.thinkify.cabbookingapp.model.Location;
import lombok.Data;

@Data
public class DrivingPartnerRequestSignUpDto
{
    private String firstName;
    private String lastName;
    private String email;
    private VehicleRequestDto vehicle;
    private Location location;
}
