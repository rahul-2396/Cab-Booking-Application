package com.thinkify.cabbookingapp.controller;

import com.thinkify.cabbookingapp.dto.requestdto.UserRequestSignUpDto;
import com.thinkify.cabbookingapp.dto.responsedto.UserResponseSignUpDto;
import com.thinkify.cabbookingapp.exception.UserNotFoundException;
import com.thinkify.cabbookingapp.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody UserRequestSignUpDto userRequestSignUpDto) {
        Long userId = userService.addUser(userRequestSignUpDto);
        return new ResponseEntity<>("User Added Successfully with id "+userId, HttpStatus.CREATED);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        try {
            UserResponseSignUpDto user = userService.findUserById(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        catch (UserNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}
