package com.example.driversregistrationjava.model.rent;

import com.example.driversregistrationjava.model.car.Car;
import com.example.driversregistrationjava.model.driver.Driver;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "rents")
public class RentCarDriver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rent_id")
    private Long id;


    @OneToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;

    @OneToOne
    @JoinColumn(name = "car_id")
    private Car car;
}
