package com.example.driversregistrationjava.model.rent.dto;


import com.example.driversregistrationjava.model.car.dto.CarDto;
import com.example.driversregistrationjava.model.driver.dto.DriverDto;
import lombok.Data;

@Data
public class RentCarDriverDto {

    private Long id;

    private CarDto carDto;

    private DriverDto driverDto;
}
