package com.example.driversregistrationjava.model.user.dto;

import com.example.driversregistrationjava.model.user.status.TypeAccess;
import lombok.Data;

@Data
public class UserDto {

    private Long id;

    private String name;

    private String lastName;

    private TypeAccess typeAccess;
}