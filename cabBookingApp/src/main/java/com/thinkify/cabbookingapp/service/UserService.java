package com.thinkify.cabbookingapp.service;

import com.thinkify.cabbookingapp.dto.requestdto.UserRequestSignUpDto;
import com.thinkify.cabbookingapp.dto.responsedto.UserResponseSignUpDto;
import com.thinkify.cabbookingapp.exception.UserNotFoundException;

public interface UserService {
    Long addUser(UserRequestSignUpDto userRequestSignUpDto);

    UserResponseSignUpDto findUserById(Long id) throws UserNotFoundException;
}
