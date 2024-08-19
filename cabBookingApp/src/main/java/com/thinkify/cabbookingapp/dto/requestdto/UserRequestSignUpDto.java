package com.thinkify.cabbookingapp.dto.requestdto;

import lombok.Data;

@Data
public class UserRequestSignUpDto
{
    private String firstName;
    private String lastName;
    private String email;
}
