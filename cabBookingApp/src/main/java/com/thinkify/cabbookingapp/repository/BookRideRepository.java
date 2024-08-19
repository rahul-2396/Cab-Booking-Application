package com.thinkify.cabbookingapp.repository;

import com.thinkify.cabbookingapp.dto.requestdto.BookRideRequestDto;
import com.thinkify.cabbookingapp.dto.responsedto.BookRideResponseDto;
import com.thinkify.cabbookingapp.dto.responsedto.DrivingPartnerResponseSignUpDto;
import com.thinkify.cabbookingapp.dto.responsedto.UserResponseSignUpDto;
import com.thinkify.cabbookingapp.exception.DriverNotFoundException;
import com.thinkify.cabbookingapp.model.Ride;
import com.thinkify.cabbookingapp.model.User;
import com.thinkify.cabbookingapp.service.DrivingPartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BookRideRepository
{
    List<Ride> rides = new ArrayList<>();

    private UserRepository userRepository;

    private DrivingPartnerService drivingPartnerService;

    @Autowired
    public BookRideRepository(UserRepository userRepository, DrivingPartnerService drivingPartnerService) {
        this.userRepository = userRepository;
        this.drivingPartnerService = drivingPartnerService;
    }
    public void save(Long id, BookRideRequestDto ride) {
        Ride newRide = new Ride();
        newRide.setId(id);
        newRide.setUserId(ride.getUserID());
        newRide.setDrivingPartnerId(ride.getDrivingPartnerID());
        newRide.setSourceLocation(ride.getSourceLocation());
        newRide.setDestinationLocation(ride.getDestinationLocation());
        rides.add(newRide);
    }



    public BookRideResponseDto findRideByUserId(Long bookingId, Long userId) throws DriverNotFoundException {
        BookRideResponseDto bookRideResponseDto = new BookRideResponseDto();
        for(Ride ride : rides) {
            if(ride.getUserId().equals(userId)) {

                bookRideResponseDto.setBookingId(bookingId);

                Optional<User> userOptional = userRepository.findByID(userId);
                User user = userOptional.get();

                UserResponseSignUpDto userResponseSignUpDto = new UserResponseSignUpDto();
                userResponseSignUpDto.setId(userId);
                userResponseSignUpDto.setFirstName(user.getFirstName());
                userResponseSignUpDto.setLastName(user.getLastName());
                userResponseSignUpDto.setEmail(user.getEmail());

                bookRideResponseDto.setUser(userResponseSignUpDto);

                DrivingPartnerResponseSignUpDto drivingPartner = drivingPartnerService.findDrivingPartnerByID(ride.getDrivingPartnerId());
                bookRideResponseDto.setDrivingPartner(drivingPartner);
                bookRideResponseDto.setSourceLocation(ride.getSourceLocation());
                bookRideResponseDto.setDestinationLocation(ride.getDestinationLocation());

                break;
            }
        }
        return bookRideResponseDto;
    }
}
