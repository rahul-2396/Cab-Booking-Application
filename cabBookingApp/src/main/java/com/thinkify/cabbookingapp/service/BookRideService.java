package com.thinkify.cabbookingapp.service;

import com.thinkify.cabbookingapp.dto.requestdto.BookRideRequestDto;
import com.thinkify.cabbookingapp.dto.responsedto.BookRideResponseDto;
import com.thinkify.cabbookingapp.dto.responsedto.DrivingPartnerResponseSignUpDto;
import com.thinkify.cabbookingapp.exception.BookingNotFoundException;
import com.thinkify.cabbookingapp.exception.DriverNotFoundException;
import com.thinkify.cabbookingapp.model.Location;

import java.util.List;

public interface BookRideService
{
    List<DrivingPartnerResponseSignUpDto> findRide(Location sourceLocation, Location destinationLocation);

    void chooseRide(BookRideRequestDto ride);

    BookRideResponseDto findBookingForUserId(Long userId) throws BookingNotFoundException, DriverNotFoundException;
}
