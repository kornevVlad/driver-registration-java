package com.example.driversregistrationjava.model.car.dto;


import com.example.driversregistrationjava.model.car.status.TypeCar;
import com.example.driversregistrationjava.model.car.status.TypeRent;
import lombok.Data;


@Data
public class CarDto {

    private Long id;

    private Integer numberCar; //номер автомобиля

    private String vinCar; //вин номер автомобиля

    private Integer yearRelease; //год выпуска

    private TypeRent typeRent; //в аренде авто или нет

    private TypeCar typeCar; //тип автомобиля
}