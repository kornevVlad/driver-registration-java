package com.example.driversregistrationjava.model.car;

import com.example.driversregistrationjava.model.car.status.TypeCar;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cars_id")
    private Long id;

    @Column(name = "number_car")
    private int numberCar; //номер автомобиля

    @Column(name = "vin_car")
    private int vinCar; //вин номер автомобиля

    @Column(name = "year_release_car")
    private int yearRelease; //год выпуска

    @Enumerated(EnumType.STRING)
    private TypeCar typeCar; //тип автомобиля
}
