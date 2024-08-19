package com.thinkify.cabbookingapp.model;

import lombok.Data;

@Data
public class Location
{
    private int latitude;
    private int longitude;

    public Location(int latitude, int longitude)
    {
        this.latitude = latitude;
        this.longitude = longitude;
    }
}


