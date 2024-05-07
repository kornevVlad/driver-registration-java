package com.example.driversregistrationjava.service.rent;

import com.example.driversregistrationjava.model.car.Car;
import com.example.driversregistrationjava.model.car.dto.CarDto;
import com.example.driversregistrationjava.model.car.mapper.CarMapper;
import com.example.driversregistrationjava.model.car.repository.CarRepository;
import com.example.driversregistrationjava.model.car.status.TypeRentDriver;
import com.example.driversregistrationjava.model.driver.Driver;
import com.example.driversregistrationjava.model.driver.dto.DriverDto;
import com.example.driversregistrationjava.model.driver.mapper.DriverMapper;
import com.example.driversregistrationjava.model.driver.repository.DriverRepository;
import com.example.driversregistrationjava.model.driver.status.TypeRentCar;
import com.example.driversregistrationjava.model.rent.RentCarDriver;
import com.example.driversregistrationjava.model.rent.dto.RentCarDriverDto;
import com.example.driversregistrationjava.model.rent.mapper.RentMapper;
import com.example.driversregistrationjava.model.rent.repository.RentRepository;
import com.example.driversregistrationjava.model.user.User;
import com.example.driversregistrationjava.model.user.repository.UserRepository;
import com.example.driversregistrationjava.model.user.status.TypeAccess;
import com.example.driversregistrationjava.validation.ValidationBadRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RentServiceImpl implements RentService {

    private final UserRepository userRepository;

    private final CarRepository carRepository;

    private final DriverRepository driverRepository;

    private final RentRepository rentRepository;

    private final RentMapper rentMapper;

    private final CarMapper carMapper;

    private final DriverMapper driverMapper;

    public RentServiceImpl(UserRepository userRepository, CarRepository carRepository,
                           DriverRepository driverRepository, RentRepository rentRepository,
                           RentMapper rentMapper, CarMapper carMapper, DriverMapper driverMapper) {
        this.userRepository = userRepository;
        this.carRepository = carRepository;
        this.driverRepository = driverRepository;
        this.rentRepository = rentRepository;
        this.rentMapper = rentMapper;
        this.carMapper = carMapper;
        this.driverMapper = driverMapper;
    }

    @Override //создание аренды
    public RentCarDriverDto createRent(Long userId, Long carId, Long driverId) {
        validationUserTypeAccess(userId); //валидация пользователя
        Driver driverRent = driverRepository.getReferenceById(driverId);
        Car carRent = carRepository.getReferenceById(carId);
        //проверка водителя на арендованность авто
        //проверка автомобиля на арендованность
        if (driverRent.getTypeRentCar() != TypeRentCar.CAR &
                carRent.getTypeRentDriver() != TypeRentDriver.FOR_RENT ) {
            driverRent.setTypeRentCar(TypeRentCar.CAR);
            carRent.setTypeRentDriver(TypeRentDriver.FOR_RENT);
            driverRepository.save(driverRent);
            carRepository.save(carRent);
        } else if (driverRent.getTypeRentCar() == TypeRentCar.CAR) {
            //водитель уже в аренде
            throw new ValidationBadRequest("A Rental driver");
        } else if (carRent.getTypeRentDriver() == TypeRentDriver.FOR_RENT) {
            //авто уже в аренде
            throw new ValidationBadRequest("A Rental car");
        }

        RentCarDriver rentCarDriver = rentMapper.toRentCarDriver(carRent, driverRent);
        rentRepository.save(rentCarDriver);
        CarDto carDto = carMapper.toCarDto(carRent);
        DriverDto driverDto = driverMapper.toDriverDto(driverRent);

        return rentMapper.rentCarDriverDto(rentCarDriver, carDto, driverDto);
    }

    @Override //обновление аренды (новый водитель)
    public RentCarDriverDto updateRentDriver(Long rentId, Long userId, Long driverId) {
        validationUserTypeAccess(userId);
        //новый водитель для аренды
        Driver driverRent = driverRepository.getReferenceById(driverId);
        RentCarDriver rentCarDriver = rentRepository.getReferenceById(rentId);

        if (driverRent.getTypeRentCar() == TypeRentCar.NOT_CAR) {
            //снятие аренды с водителя арендованного авто
            Driver driverNotRent = rentCarDriver.getDriver();
            driverNotRent.setTypeRentCar(TypeRentCar.NOT_CAR);
            driverRepository.save(driverNotRent);
            //назначение аренды нового водителя
            driverRent.setTypeRentCar(TypeRentCar.CAR);
            rentCarDriver.setDriver(driverRent);
            rentRepository.save(rentCarDriver);
        } else {
            throw new ValidationBadRequest("RENTAL DRIVER");
        }
        return rentMapper.rentCarDriverDto(rentCarDriver,
                carMapper.toCarDto(rentCarDriver.getCar()),
                driverMapper.toDriverDto(rentCarDriver.getDriver()));
    }

    @Override //обновление аренды (новый автомобиль)
    public RentCarDriverDto updateRentCar(Long rentId, Long userId, Long carId) {
        validationUserTypeAccess(userId);
        RentCarDriver rentCarDriver = rentRepository.getReferenceById(rentId);
        Car carRental = carRepository.getReferenceById(carId);
        //проверка автомобиля на аренду
        if (carRental.getTypeRentDriver() == TypeRentDriver.NOT_FOR_RENT) {
            Car carNotRent = rentCarDriver.getCar();
            carNotRent.setTypeRentDriver(TypeRentDriver.NOT_FOR_RENT);
            carRepository.save(carNotRent);

            carRental.setTypeRentDriver(TypeRentDriver.FOR_RENT);
            rentCarDriver.setCar(carRental);
            rentRepository.save(rentCarDriver);
        } else {
            throw new ValidationBadRequest("RENTAL CAR");
        }
        return rentMapper.rentCarDriverDto(rentCarDriver,
                carMapper.toCarDto(rentCarDriver.getCar()),
                driverMapper.toDriverDto(rentCarDriver.getDriver()));
    }

    @Override //удаление аренды
    public void deleteRentById(Long rentId, Long userId) {
        validationUserTypeAccess(userId);
        RentCarDriver rentCarDriver = validationRentCarDriverById(rentId);
        Driver driverDeleteRent = rentCarDriver.getDriver();
        driverDeleteRent.setTypeRentCar(TypeRentCar.NOT_CAR);
        Car carDeleteRent = rentCarDriver.getCar();
        carDeleteRent.setTypeRentDriver(TypeRentDriver.NOT_FOR_RENT);
        rentRepository.deleteById(rentId);
        driverRepository.save(driverDeleteRent);
        carRepository.save(carDeleteRent);
    }

    @Override //получение аренды по ID
    public RentCarDriverDto getRentalById(Long rentId) {
        return null;
    }

    @Override //получение списка аренды
    public List<RentCarDriverDto> getRentalList() {
        return null;
    }

    /**
     * валидация доспута пульзователя
     */
    private void validationUserTypeAccess(Long userId) {
        User validUser = userRepository.getReferenceById(userId);
        log.info("User {}", userId);
        if (validUser.getTypeAccess() != TypeAccess.FULL_ACCESS) {
            //отказ в добавлении аренды не соответствие типа доступа user
            //PARTIAL_ACCESS //частичный доступ
            throw new ValidationBadRequest("Not Access");
        }
    }

    private RentCarDriver validationRentCarDriverById(Long rentId) {
        if (!rentRepository.existsById(rentId)) {
            log.error("Аренда с id {} не найдена", rentId);
            throw new ValidationBadRequest("RENTAL NOT FOUND");
        } else {
            log.info("Аренда с id {} прошла верификацию", rentId);
            return rentRepository.getReferenceById(rentId);
        }
    }
}
