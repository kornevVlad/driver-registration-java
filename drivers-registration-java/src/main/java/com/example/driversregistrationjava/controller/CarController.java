package com.example.driversregistrationjava.controller;


import com.example.driversregistrationjava.model.admin.dto.UserDto;
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

    @PostMapping() //создание автомобиля
    public CarDto createCar(@RequestBody CarDto carDto) {
        log.info("Car {}", carDto);
        return carService.createCar(carDto);
    }

    @PatchMapping("/{carId}") //обновление данных автомобиля
    public CarDto updateCar(@RequestBody CarDto carDto, @PathVariable Long carId) {
        log.info("Car {}, id {}", carDto, carId);
        return carService.updateCar(carDto, carId);
    }

    @DeleteMapping("/{carId}") //удаление автомобиля
    public void deleteCar(@PathVariable Long carId) {
        carService.deleteCar(carId);
    }
}