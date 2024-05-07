package com.example.driversregistrationjava.model.driver.repository;

import com.example.driversregistrationjava.model.driver.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

    Driver findByNumberDriverLicense(String numberDriverLicense);
}
