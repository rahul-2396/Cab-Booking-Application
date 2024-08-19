package com.thinkify.cabbookingapp.dto.responsedto;

import lombok.Data;

@Data
public class UserResponseSignUpDto
{
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
