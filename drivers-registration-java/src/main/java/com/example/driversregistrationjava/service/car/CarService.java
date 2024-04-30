package com.example.driversregistrationjava.service.car;

import com.example.driversregistrationjava.model.car.dto.CarDto;

public interface CarService {

    CarDto createCar(CarDto carDto); //добавление автомобиля

    CarDto updateCar(CarDto carDto, Long id); //обновление автомобиля

    void deleteCar(Long id); //удаление автомобиля
}
