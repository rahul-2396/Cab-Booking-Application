package com.thinkify.cabbookingapp.serviceimpl;

import com.thinkify.cabbookingapp.dto.requestdto.BookRideRequestDto;
import com.thinkify.cabbookingapp.dto.responsedto.BookRideResponseDto;
import com.thinkify.cabbookingapp.dto.responsedto.DrivingPartnerResponseSignUpDto;
import com.thinkify.cabbookingapp.exception.BookingNotFoundException;
import com.thinkify.cabbookingapp.exception.DriverNotFoundException;
import com.thinkify.cabbookingapp.model.Location;
import com.thinkify.cabbookingapp.repository.BookRideRepository;
import com.thinkify.cabbookingapp.repository.DrivingPartnerRepository;
import com.thinkify.cabbookingapp.service.BookRideService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.awt.geom.Point2D.distance;

@Service
public class BookRideServiceImpl implements BookRideService {

    private Long bookingId = 1L;

    private DrivingPartnerRepository drivingPartnerRepository;
    private BookRideRepository bookRideRepository;


    public BookRideServiceImpl(DrivingPartnerRepository drivingPartnerRepository, BookRideRepository bookRideRepository) {
        this.drivingPartnerRepository = drivingPartnerRepository;
        this.bookRideRepository = bookRideRepository;
    }

    @Override
    public List<DrivingPartnerResponseSignUpDto> findRide(Location sourceLocation, Location destinationLocation) {
        List<DrivingPartnerResponseSignUpDto> drivers = drivingPartnerRepository.findAllDrivers();
        List<DrivingPartnerResponseSignUpDto> driversAvailable = new ArrayList<>();
        for(DrivingPartnerResponseSignUpDto drivingPartner : drivers) {
            if(distance(drivingPartner.getLocation().getLatitude(),drivingPartner.getLocation().getLongitude()
                    ,sourceLocation.getLatitude(),sourceLocation.getLongitude()) <= 5) {

                driversAvailable.add(drivingPartner);
            }
        }

        return driversAvailable;
    }



    @Override
    public void chooseRide(BookRideRequestDto ride) {
        bookRideRepository.save(bookingId++,ride);
    }



    @Override
    public BookRideResponseDto findBookingForUserId(Long userId) throws BookingNotFoundException, DriverNotFoundException {
        BookRideResponseDto bookRideResponseDto = bookRideRepository.findRideByUserId(bookingId,userId);
        if(bookRideResponseDto.getUser() == null) {
            throw new BookingNotFoundException("No Booking Found");
        }
        return bookRideResponseDto;
    }

}
