package com.example.driversregistrationjava.service.rent;

import com.example.driversregistrationjava.model.rent.dto.RentCarDriverDto;

import java.util.List;

public interface RentService {

    RentCarDriverDto createRent(Long userId, Long carId, Long driverId);

    RentCarDriverDto updateRentDriver(Long rentId,Long userId, Long driverId);

    RentCarDriverDto updateRentCar(Long rentId,Long userId, Long carId);

    void deleteRentById(Long rentId, Long userId);

    RentCarDriverDto getRentalById(Long rentId);

    List<RentCarDriverDto> getRentalList();
}
