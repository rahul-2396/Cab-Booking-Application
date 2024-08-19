package com.thinkify.cabbookingapp.controller;

import com.thinkify.cabbookingapp.dto.requestdto.BookRideRequestDto;
import com.thinkify.cabbookingapp.dto.responsedto.BookRideResponseDto;
import com.thinkify.cabbookingapp.dto.responsedto.DrivingPartnerResponseSignUpDto;
import com.thinkify.cabbookingapp.exception.BookingNotFoundException;
import com.thinkify.cabbookingapp.exception.DriverNotFoundException;
import com.thinkify.cabbookingapp.model.Location;
import com.thinkify.cabbookingapp.service.BookRideService;
import com.thinkify.cabbookingapp.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {

    private UserService userService;
    private BookRideService bookRideService;

    public BookingController(UserService userService, BookRideService bookRideService) {
        this.userService = userService;
        this.bookRideService = bookRideService;
    }

    @GetMapping("/findRide")
    public ResponseEntity<?> findRide(@RequestParam int sourceLat,
                                      @RequestParam int sourceLong,
                                      @RequestParam int destinationLat,
                                      @RequestParam int destinationLong) {


        Location sourceLocation = new Location(sourceLat, sourceLong);
        Location destinationLocation = new Location(destinationLat, destinationLong);
        try {
            List<DrivingPartnerResponseSignUpDto> driversAvailable = bookRideService.findRide(sourceLocation, destinationLocation);
            if (driversAvailable.isEmpty()) {
                throw new DriverNotFoundException("Drivers Not Found");
            }
            return new ResponseEntity<>(driversAvailable, HttpStatus.OK);
        } catch (DriverNotFoundException driverNotFoundException) {
            return new ResponseEntity<>(driverNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/ride")
    public ResponseEntity<String> chooseRide(@RequestBody BookRideRequestDto ride) {
        bookRideService.chooseRide(ride);
        return new ResponseEntity<>("Driver ID "+ride.getDrivingPartnerID(),HttpStatus.OK);
    }

    @GetMapping("/ride/{userId}")
    ResponseEntity<?> findRideForUserId(@PathVariable Long userId) {
        try {
            BookRideResponseDto bookRide = bookRideService.findBookingForUserId(userId);
            return new ResponseEntity<>(bookRide, HttpStatus.OK);
        }
        catch (BookingNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
        catch (DriverNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}
