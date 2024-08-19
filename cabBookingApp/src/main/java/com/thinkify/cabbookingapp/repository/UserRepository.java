package com.thinkify.cabbookingapp.repository;

import com.thinkify.cabbookingapp.dto.requestdto.UserRequestSignUpDto;
import com.thinkify.cabbookingapp.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Optional;

@Repository
public class UserRepository
{
    private HashMap<Long, User> users = new HashMap<>();
    public Optional<User> findByID(Long userID) {
        return Optional.ofNullable(users.get(userID));
    }

    public void save(Long userId, UserRequestSignUpDto userRequestSignUpDto) {
        User user = new User();
        user.setId(userId);
        user.setFirstName(userRequestSignUpDto.getFirstName());
        user.setLastName(userRequestSignUpDto.getLastName());
        user.setEmail(userRequestSignUpDto.getEmail());
        users.put(userId,user);
    }
}
