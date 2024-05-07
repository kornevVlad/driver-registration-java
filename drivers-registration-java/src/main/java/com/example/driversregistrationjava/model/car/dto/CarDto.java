package com.example.driversregistrationjava.model.car.dto;


import com.example.driversregistrationjava.model.car.status.TypeCar;
import com.example.driversregistrationjava.model.car.status.TypeRentDriver;
import lombok.Data;


@Data
public class CarDto {

    private Long id;

    private String carBrand; //марка автомобиля

    private String carModel; //модель автомобиля

    private String numberCar; //номер автомобиля

    private String vinCar; //вин номер автомобиля

    private Integer yearRelease; //год выпуска

    private TypeRentDriver typeRentDriver; //в аренде авто или нет

    private TypeCar typeCar; //тип автомобиля
}