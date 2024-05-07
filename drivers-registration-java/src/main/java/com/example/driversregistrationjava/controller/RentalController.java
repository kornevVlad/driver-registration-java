package com.example.driversregistrationjava.controller;

import com.example.driversregistrationjava.model.rent.dto.RentCarDriverDto;
import com.example.driversregistrationjava.service.rent.RentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/rents")
@RequiredArgsConstructor
@Slf4j
public class RentalController {

    private final RentService rentService;

    @PostMapping("/{userId}")//создание аренды автомобиля водителем
    public RentCarDriverDto createRent(@PathVariable Long userId, @RequestParam Long carId, @RequestParam Long driverId) {
        log.info("User {}, CarId {}, DriverId {}", userId, carId, driverId);
        return rentService.createRent(userId, carId, driverId);
    }

    @PatchMapping("/{rentId}/{userId}")//обновление аренды (новый водитель)
    public RentCarDriverDto updateRentDriver(@PathVariable Long rentId, @PathVariable Long userId,
                                             @RequestParam Long driverId) {
        log.info("RentId {}, UserId {}, DriverId {}", rentId, userId, driverId);
        return rentService.updateRentDriver(rentId, userId, driverId);
    }

    @PatchMapping("/{rentId}/{userId}/{carId}")//обновление аренды (новый автомобиль)
    public RentCarDriverDto updateRentCar(@PathVariable Long rentId, @PathVariable Long userId,
                                             @PathVariable Long carId) {
        log.info("RentId {}, UserId {}, CarId {}", rentId, userId, carId);
        return rentService.updateRentCar(rentId, userId, carId);
    }

    @DeleteMapping("/{rentId}/{userId}")//удаление аренды по ID
    public void deleteRentById(@PathVariable Long rentId, @PathVariable Long userId) {
        log.info("RentId {}, UserId {}", rentId, userId);
        rentService.deleteRentById(rentId, userId);
    }

    @GetMapping//получение аренды по ID
    public RentCarDriverDto getRentalById() {
        return null;
    }

    @GetMapping("/rentalAll") //получение списка аренды
    public List<RentCarDriverDto> getRentalList() {
        return null;
    }
}
