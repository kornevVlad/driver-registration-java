package com.example.driversregistrationjava.service.driver;

import com.example.driversregistrationjava.model.driver.dto.DriverDto;

public interface DriverService {

    DriverDto createDriver(DriverDto driverDto, Long userId);

    DriverDto updateDriver(DriverDto driverDto, Long driverId, Long userId);

    void deleteDriver(Long driverId, Long userId);
}
