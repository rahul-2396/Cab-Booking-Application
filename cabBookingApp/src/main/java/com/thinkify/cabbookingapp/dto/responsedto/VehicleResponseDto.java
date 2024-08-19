package com.thinkify.cabbookingapp.dto.responsedto;

import com.thinkify.cabbookingapp.enums.VehicleType;
import lombok.Data;

@Data
public class VehicleResponseDto
{
    private Long id;
    private VehicleType vehicleType;
    private String vehicleNumber;
}


