package com.thinkify.cabbookingapp.serviceimpl;

import com.thinkify.cabbookingapp.dto.requestdto.UserRequestSignUpDto;
import com.thinkify.cabbookingapp.dto.responsedto.UserResponseSignUpDto;
import com.thinkify.cabbookingapp.exception.UserNotFoundException;
import com.thinkify.cabbookingapp.model.User;
import com.thinkify.cabbookingapp.repository.UserRepository;
import com.thinkify.cabbookingapp.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private Long id = 1L;
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Long addUser(UserRequestSignUpDto userRequestSignUpDto) {
        userRepository.save(id,userRequestSignUpDto);
        return  id++;
    }

    @Override
    public UserResponseSignUpDto findUserById(Long id) throws UserNotFoundException {
        Optional<User> userOptional = userRepository.findByID(id);
        //System.out.println(userOptional);
        if(userOptional.isEmpty()) {
            //System.out.println("HiQQ");
            throw new UserNotFoundException("User Not Found");
        }
        UserResponseSignUpDto userResponseSignUpDto = new UserResponseSignUpDto();
        User user = userOptional.get();
        userResponseSignUpDto.setId(user.getId());
        userResponseSignUpDto.setFirstName(user.getFirstName());
        userResponseSignUpDto.setLastName(user.getLastName());
        userResponseSignUpDto.setEmail(user.getEmail());
        return userResponseSignUpDto;
    }
}
