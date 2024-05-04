package com.example.driversregistrationjava.service.rent;

import com.example.driversregistrationjava.model.rent.dto.RentCarDriverDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RentServiceImpl implements RentService {


    @Override //создание аренды
    public RentCarDriverDto createRent(Long carId, Long driverId, Long userId) {
        return null;
    }

    @Override //обновление аренды
    public RentCarDriverDto updateRent(Long rentId, Long carId, Long driverId, Long userId) {
        return null;
    }

    @Override //удаление аренды
    public void deleteRent(Long rentId, Long userId) {

    }

    @Override //получение аренды по ID
    public RentCarDriverDto getRentalById(Long rentId) {
        return null;
    }

    @Override //получение списка аренды
    public List<RentCarDriverDto> getRentalList() {
        return null;
    }
}
