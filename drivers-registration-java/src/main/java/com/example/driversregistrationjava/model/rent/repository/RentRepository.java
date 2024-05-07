package com.example.driversregistrationjava.model.rent.repository;

import com.example.driversregistrationjava.model.rent.RentCarDriver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentRepository extends JpaRepository<RentCarDriver, Long> {

}
