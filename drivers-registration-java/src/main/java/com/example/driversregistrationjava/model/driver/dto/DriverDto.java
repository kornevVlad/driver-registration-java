package com.example.driversregistrationjava.model.driver.dto;

import com.example.driversregistrationjava.model.car.Car;
import com.example.driversregistrationjava.model.driver.status.TypeRentCar;
import lombok.Data;


@Data
public class DriverDto {

    private Long id;

    private String name; //имя

    private String lastName; //фамилия

    private String numberDriverLicense; //номер водительского удостоверения

    private Integer drivingExperience; //стаж вождения

    private TypeRentCar typeRentCar; //арендовал автомобиль или нет
}