package com.example.driversregistrationjava.service.car;

import com.example.driversregistrationjava.model.car.Car;
import com.example.driversregistrationjava.model.car.dto.CarDto;
import com.example.driversregistrationjava.model.car.mapper.CarMapper;
import com.example.driversregistrationjava.model.car.repository.CarRepository;
import com.example.driversregistrationjava.model.user.User;
import com.example.driversregistrationjava.model.user.repository.UserRepository;
import com.example.driversregistrationjava.model.user.status.TypeAccess;
import com.example.driversregistrationjava.validation.ValidationBadRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    private final CarMapper carMapper;

    private final UserRepository userRepository;

    public CarServiceImpl(CarRepository carRepository, CarMapper carMapper, UserRepository userRepository) {
        this.carRepository = carRepository;
        this.carMapper = carMapper;
        this.userRepository = userRepository;
    }

    /**
     * добавление автомобиля
     */
    @Override
    public CarDto createCar(CarDto carDto, Long userId) {
        validationUserTypeAccess(userId); //валидация типа доступа пользователя
        Car car = carMapper.CarDto(carDto);
        carRepository.save(car);
        return carMapper.toCarDto(car);
    }

    /**
     * обновление данных автомобиля
     */
    @Override
    public CarDto updateCar(CarDto carDto, Long carId, Long userId) {
        validationUserTypeAccess(userId);
        Car car = carRepository.getReferenceById(carId);
        Car upCar = carMapper.CarDto(carDto);
        if (upCar.getNumberCar() != null) {
            car.setNumberCar(upCar.getNumberCar());
        }
        if (upCar.getCarBrand() != null) {
            car.setCarBrand(upCar.getCarBrand());
        }
        if (upCar.getCarModel() != null) {
            car.setCarModel(upCar.getCarModel());
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
    public void deleteCar(Long carId, Long userId) {
        validationUserTypeAccess(userId);
        carRepository.deleteById(carId);
    }

    /**
     * валидация доспута пульзователя
     */
    private void validationUserTypeAccess(Long userId) {
        User validUser = userRepository.getReferenceById(userId);
        log.info("User {}", validUser);
        if (validUser.getTypeAccess() != TypeAccess.FULL_ACCESS) {
            //отказ в добавлении авто не соответствие типа доступа user
            //PARTIAL_ACCESS //частичный доступ
            throw new  ValidationBadRequest("Not Access");
        }
    }
}