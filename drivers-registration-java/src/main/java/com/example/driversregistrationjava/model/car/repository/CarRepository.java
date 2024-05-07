package com.example.driversregistrationjava.model.car.repository;

import com.example.driversregistrationjava.model.car.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    Car findByVinCar(String vinCar);
}
