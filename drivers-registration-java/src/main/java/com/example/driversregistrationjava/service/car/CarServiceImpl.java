package com.example.driversregistrationjava.service.car;

import com.example.driversregistrationjava.model.car.Car;
import com.example.driversregistrationjava.model.car.dto.CarDto;
import com.example.driversregistrationjava.model.car.mapper.CarMapper;
import com.example.driversregistrationjava.model.car.repository.CarRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    private final CarMapper carMapper;

    public CarServiceImpl(CarRepository carRepository, CarMapper carMapper) {
        this.carRepository = carRepository;
        this.carMapper = carMapper;
    }


    /**
     * добавление автомобиля
     */
    @Override
    public CarDto createCar(CarDto carDto) {
        return carMapper.toCarDto(carRepository.save(carMapper.CarDto(carDto)));
    }

    /**
     * обновление данных автомобиля
     */
    @Override
    public CarDto updateCar(CarDto carDto, Long id) {
        Car car = carRepository.getReferenceById(id);
        Car upCar = carMapper.CarDto(carDto);
        if (upCar.getNumberCar() != null) {
            car.setNumberCar(upCar.getNumberCar());
        }
        if (upCar.getVinCar() != null) {
            car.setVinCar(upCar.getVinCar());
        }
        if (upCar.getYearRelease() != null) {
            car.setYearRelease(upCar.getYearRelease());
        }
        if (upCar.getTypeRentDriver() != null) {
            car.setTypeRentDriver(upCar.getTypeRentDriver());
        }
        if (upCar.getTypeCar() != null) {
            car.setTypeCar(upCar.getTypeCar());
        }
        return carMapper.toCarDto(carRepository.save(car));
    }

    /**
     * удаление автомобиля по id
     */
    @Override
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
}
