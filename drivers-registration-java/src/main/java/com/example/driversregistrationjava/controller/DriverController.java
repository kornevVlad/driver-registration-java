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

    @PostMapping("/{userId}") //создание водителя
    public DriverDto createUser(@RequestBody DriverDto driverDto, @PathVariable Long userId) {
        log.info("Driver {}, UserId {}", driverDto, userId);
        return driverService.createDriver(driverDto, userId);
    }

    @PatchMapping("/{driverId}/{userId}") //обновление водителя
    public DriverDto updateDriver(@RequestBody DriverDto driverDto, @PathVariable Long driverId,
                                  @PathVariable Long userId) {
        log.info("Driver {}, driverId {}, userId {}", driverDto, driverId, userId);
        return driverService.updateDriver(driverDto, driverId, userId);
    }

    @DeleteMapping("/{driverId}/{userId}") //удаление водителя
    public void deleteDriver(@PathVariable Long driverId, @PathVariable Long userId) {
        log.info("DriverId {}, userId {}", driverId, userId);
        driverService.deleteDriver(driverId, userId);
    }
}