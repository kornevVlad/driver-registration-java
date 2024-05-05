package com.example.driversregistrationjava.service.car;

import com.example.driversregistrationjava.model.car.dto.CarDto;

public interface CarService {

    CarDto createCar(CarDto carDto, Long userId); //добавление автомобиля, пользователем в статусе FULL_ACCESS

    CarDto updateCar(CarDto carDto, Long carId, Long userId); //обновление автомобиля

    void deleteCar(Long carId, Long userId); //удаление автомобиля
}
