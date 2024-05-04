package com.example.driversregistrationjava.controller;


import com.example.driversregistrationjava.model.driver.dto.DriverDto;
import com.example.driversregistrationjava.service.driver.DriverService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/drivers")
@RequiredArgsConstructor
@Slf4j
public class DriverController {

    private final DriverService driverService;

    @PostMapping() //создание водителя
    public DriverDto createUser(@RequestBody DriverDto driverDto) {
        log.info("Driver {}", driverDto);
        return driverService.createDriver(driverDto);
    }

    @PatchMapping("/{driverId}") //обновление водителя
    public DriverDto updateDriver(@RequestBody DriverDto driverDto, @PathVariable Long driverId) {
        log.info("Driver {}, id {}", driverDto, driverId);
        return driverService.updateDriver(driverDto, driverId);
    }

    @DeleteMapping("/{driverId}") //удаление водителя
    public void deleteDriver(@PathVariable Long driverId) {
        log.info("DriverId {}", driverId);
        driverService.deleteDriver(driverId);
    }
}