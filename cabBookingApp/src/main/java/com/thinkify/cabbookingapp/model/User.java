package com.thinkify.cabbookingapp.model;

import lombok.Data;

import java.util.UUID;

@Data
public class User
{
    private String firstName;
    private String lastName;
    private String email;
    private Long id;
}


