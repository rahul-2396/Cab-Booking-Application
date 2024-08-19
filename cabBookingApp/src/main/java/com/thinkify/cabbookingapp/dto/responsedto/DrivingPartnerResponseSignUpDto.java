package com.thinkify.cabbookingapp.dto.responsedto;

import com.thinkify.cabbookingapp.model.Location;
import lombok.Data;

@Data
public class DrivingPartnerResponseSignUpDto
{
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private VehicleResponseDto vehicle;
    private Location location;
}
