package com.example.driversregistrationjava.controller;


import com.example.driversregistrationjava.model.car.dto.CarDto;
import com.example.driversregistrationjava.service.car.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/cars")
@RequiredArgsConstructor
@Slf4j
public class CarController {

    private final CarService carService;

    @PostMapping("/{userId}") //создание автомобиля
    public CarDto createCar(@RequestBody CarDto carDto, @PathVariable Long userId) {
        log.info("Car {} , UserId {}", carDto, userId);
        return carService.createCar(carDto, userId);
    }

    @PatchMapping("/{carId}/{userId}") //обновление данных автомобиля
    public CarDto updateCar(@RequestBody CarDto carDto, @PathVariable Long carId,
                            @PathVariable Long userId) {
        log.info("Car {}, id {}", carDto, carId);
        return carService.updateCar(carDto, carId, userId);
    }

    @DeleteMapping("/{carId}/{userId}") //удаление автомобиля
    public void deleteCar(@PathVariable Long carId, @PathVariable Long userId) {
        carService.deleteCar(carId, userId);
    }
}