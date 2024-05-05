package com.example.driversregistrationjava.model.rent.mapper;

import com.example.driversregistrationjava.model.car.Car;
import com.example.driversregistrationjava.model.driver.Driver;
import com.example.driversregistrationjava.model.rent.RentCarDriver;
import org.springframework.stereotype.Component;

@Component
public class RentMapper {

    /**
     * из DTO в RENT
     */

    public RentCarDriver toRentCarDriver(Car car, Driver driver) {
        return null;
    }

    /**
     * из Rent в DTO
     */
    public RentCarDriver rentCarDriver() {
        return null;
    }
}
