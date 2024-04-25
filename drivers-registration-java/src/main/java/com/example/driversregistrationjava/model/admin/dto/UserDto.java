package com.example.driversregistrationjava.model.admin.dto;

import com.example.driversregistrationjava.model.admin.status.TypeAccess;
import lombok.Data;

@Data
public class UserDto {

    private Long id;

    private String name;

    private String lastName;

    private TypeAccess typeAccess;
}