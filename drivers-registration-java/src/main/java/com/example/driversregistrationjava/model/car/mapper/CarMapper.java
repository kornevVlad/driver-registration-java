package com.example.driversregistrationjava.model.car.mapper;


import com.example.driversregistrationjava.model.car.Car;
import com.example.driversregistrationjava.model.car.dto.CarDto;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {

    /**
     * из DTO в объект
     */
    public Car CarDto(CarDto carDto) {
        Car car = new Car();
        car.setId(carDto.getId());
        car.setNumberCar(carDto.getNumberCar());
        car.setVinCar(carDto.getVinCar());
        car.setYearRelease(carDto.getYearRelease());
        car.setTypeRentDriver(carDto.getTypeRentDriver());
        car.setTypeCar(carDto.getTypeCar());
        return car;
    }

    /**
     * из объекта в DTO
     */
    public CarDto toCarDto(Car car) {
        CarDto carDto = new CarDto();
        carDto.setId(car.getId());
        carDto.setNumberCar(car.getNumberCar());
        carDto.setVinCar(car.getVinCar());
        carDto.setYearRelease(car.getYearRelease());
        carDto.setTypeRentDriver(car.getTypeRentDriver());
        carDto.setTypeCar(car.getTypeCar());
        return carDto;
    }
}
