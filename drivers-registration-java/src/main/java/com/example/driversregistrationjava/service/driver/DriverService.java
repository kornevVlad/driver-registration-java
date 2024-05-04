package com.example.driversregistrationjava.service.driver;

import com.example.driversregistrationjava.model.driver.dto.DriverDto;

public interface DriverService {

    DriverDto createDriver(DriverDto driverDto);

    DriverDto updateDriver(DriverDto driverDto, Long id);

    void deleteDriver(Long id);
}
