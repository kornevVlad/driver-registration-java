package com.example.driversregistrationjava.model.car;

import com.example.driversregistrationjava.model.car.status.TypeCar;
import com.example.driversregistrationjava.model.car.status.TypeRentDriver;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private Long id;

    @Column(name = "number_car")
    private String numberCar; //номер автомобиля

    @Column(name = "vin_car")
    private String vinCar; //вин номер автомобиля

    @Column(name = "year_release_car")
    private Integer yearRelease; //год выпуска

    @Enumerated(EnumType.STRING)
    private TypeRentDriver typeRentDriver; //в аренде авто или нет

    @Enumerated(EnumType.STRING)
    private TypeCar typeCar; //тип автомобиля
}
