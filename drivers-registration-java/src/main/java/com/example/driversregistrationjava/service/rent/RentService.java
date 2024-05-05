package com.example.driversregistrationjava.service.rent;

import com.example.driversregistrationjava.model.rent.dto.RentCarDriverDto;

import java.util.List;

public interface RentService {

    RentCarDriverDto createRent(Long carId, Long driverId, Long userId);

    RentCarDriverDto updateRent(Long rentId, Long carId, Long driverId, Long userId);

    void deleteRent(Long rentId, Long userId);

    RentCarDriverDto getRentalById(Long rentId);

    List<RentCarDriverDto> getRentalList();
}
