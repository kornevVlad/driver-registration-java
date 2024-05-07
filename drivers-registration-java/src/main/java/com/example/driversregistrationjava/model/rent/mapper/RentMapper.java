package com.example.driversregistrationjava.model.rent.mapper;

import com.example.driversregistrationjava.model.car.Car;
import com.example.driversregistrationjava.model.car.dto.CarDto;
import com.example.driversregistrationjava.model.driver.Driver;
import com.example.driversregistrationjava.model.driver.dto.DriverDto;
import com.example.driversregistrationjava.model.rent.RentCarDriver;
import com.example.driversregistrationjava.model.rent.dto.RentCarDriverDto;
import org.springframework.stereotype.Component;

@Component
public class RentMapper {

    /**
     * из DTO в RENT
     */

    public RentCarDriver toRentCarDriver(Car car, Driver driver) {
        RentCarDriver rentCarDriver = new RentCarDriver();
        rentCarDriver.setCar(car);
        rentCarDriver.setDriver(driver);
        return rentCarDriver;
    }

    /**
     * из Rent в DTO
     */
    public RentCarDriverDto rentCarDriverDto(RentCarDriver rentCarDriver, CarDto carDto, DriverDto driverDto) {
        RentCarDriverDto rentCarDriverDto = new RentCarDriverDto();
        rentCarDriverDto.setId(rentCarDriver.getId());
        rentCarDriverDto.setDriverDto(driverDto);
        rentCarDriverDto.setCarDto(carDto);
        return rentCarDriverDto;
    }
}
