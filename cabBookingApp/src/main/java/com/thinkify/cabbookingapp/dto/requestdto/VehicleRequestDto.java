package com.thinkify.cabbookingapp.dto.requestdto;

import com.thinkify.cabbookingapp.enums.VehicleType;
import lombok.Data;

@Data
public class VehicleRequestDto
{
    private VehicleType vehicleType;
    private String vehicleNumber;
}
