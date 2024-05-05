package com.example.driversregistrationjava.model.driver.mapper;

import com.example.driversregistrationjava.model.driver.Driver;
import com.example.driversregistrationjava.model.driver.dto.DriverDto;
import org.springframework.stereotype.Component;

@Component
public class DriverMapper {

    /**
     * из DriverDto в Driver
     */

    public Driver driverDto(DriverDto driverDto) {
        Driver driver = new Driver();
        driver.setId(driverDto.getId());
        driver.setName(driverDto.getName());
        driver.setLastName(driverDto.getLastName());
        driver.setNumberDriverLicense(driverDto.getNumberDriverLicense());
        driver.setDrivingExperience(driverDto.getDrivingExperience());
        driver.setTypeRentCar(driverDto.getTypeRentCar());
        return driver;
    }

    /**
     * из Driver в DriverDto
     */

    public DriverDto toDriverDto(Driver driver) {
        DriverDto driverDto = new DriverDto();
        driverDto.setId(driver.getId());
        driverDto.setName(driver.getName());
        driverDto.setLastName(driver.getLastName());
        driverDto.setDrivingExperience(driver.getDrivingExperience());
        driverDto.setNumberDriverLicense(driver.getNumberDriverLicense());
        driverDto.setTypeRentCar(driver.getTypeRentCar());
        return driverDto;
    }
}
