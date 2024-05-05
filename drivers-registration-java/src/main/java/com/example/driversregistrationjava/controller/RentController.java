package com.example.driversregistrationjava.controller;

import com.example.driversregistrationjava.model.rent.dto.RentCarDriverDto;
import com.example.driversregistrationjava.service.rent.RentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/rents")
@RequiredArgsConstructor
@Slf4j
public class RentController {

    private final RentService rentService;

    @PostMapping//создание аренды автомобиля водителем
    public RentCarDriverDto createRent() {
        return null;
    }

    @PatchMapping//обновление аренды
    public RentCarDriverDto updateRent() {
        return null;
    }

    @DeleteMapping//удаление аренды
    public void deleteRent() {
    }

    @GetMapping//получение аренды по ID
    public RentCarDriverDto getRentalById() {
        return null;
    }

    @GetMapping("/rentalAll") //получение списка аренды
    public List<RentCarDriverDto> getRentalList() {
        return null;
    }
}
