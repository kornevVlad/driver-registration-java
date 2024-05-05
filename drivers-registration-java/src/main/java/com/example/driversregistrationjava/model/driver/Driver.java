package com.example.driversregistrationjava.model.driver;

import com.example.driversregistrationjava.model.car.Car;
import com.example.driversregistrationjava.model.driver.status.TypeRentCar;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "drivers")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "driver_id")
    private Long id;

    @Column(name = "driver_name")
    private String name; //имя

    @Column(name = "driver_last_name")
    private String lastName; //фамилия

    @Column(name = "number_driver_license")
    private String numberDriverLicense; //номер водительского удостоверения

    @Column(name = "driving_experience")
    private Integer drivingExperience; //стаж вождения

    @Enumerated(EnumType.STRING)
    private TypeRentCar typeRentCar; //арендовал автомобиль или нет
}