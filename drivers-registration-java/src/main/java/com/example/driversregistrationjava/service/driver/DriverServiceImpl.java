package com.example.driversregistrationjava.service.driver;

import com.example.driversregistrationjava.model.driver.Driver;
import com.example.driversregistrationjava.model.driver.dto.DriverDto;
import com.example.driversregistrationjava.model.driver.mapper.DriverMapper;
import com.example.driversregistrationjava.model.driver.repository.DriverRepository;
import com.example.driversregistrationjava.model.user.User;
import com.example.driversregistrationjava.model.user.repository.UserRepository;
import com.example.driversregistrationjava.model.user.status.TypeAccess;
import com.example.driversregistrationjava.validation.ValidationBadRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DriverServiceImpl implements DriverService{

    private final DriverRepository driverRepository;

    private final DriverMapper driverMapper;

    private final UserRepository userRepository;

    public DriverServiceImpl(DriverRepository driverRepository, DriverMapper driverMapper,
                             UserRepository userRepository) {
        this.driverRepository = driverRepository;
        this.driverMapper = driverMapper;
        this.userRepository = userRepository;
    }

    /**
     * создание водителя
     */
    @Override
    public DriverDto createDriver(DriverDto driverDto, Long userId) {
        validationUserTypeAccess(userId);
        return driverMapper.toDriverDto(driverRepository.save(driverMapper.driverDto(driverDto)));
    }

    /**
     * обновление водителя
     */
    @Override
    public DriverDto updateDriver(DriverDto driverDto, Long driverId, Long userId) {
        validationUserTypeAccess(userId);
        Driver driver = driverRepository.getReferenceById(driverId);
        Driver upDriver = driverMapper.driverDto(driverDto);
        if (upDriver.getName() != null) {
            driver.setName(upDriver.getName());
        }
        if (upDriver.getLastName() != null) {
            driver.setLastName(upDriver.getLastName());
        }
        if (upDriver.getDrivingExperience() != null) {
            driver.setDrivingExperience(upDriver.getDrivingExperience());
        }
        if (upDriver.getNumberDriverLicense() != null) {
            driver.setNumberDriverLicense(upDriver.getNumberDriverLicense());
        }
        if (upDriver.getTypeRentCar() != null) {
            driver.setTypeRentCar(upDriver.getTypeRentCar());
        }
        return driverMapper.toDriverDto(driverRepository.save(driver));
    }

    /**
     * удаление водителя
     */
    @Override
    public void deleteDriver(Long driverId, Long userId) {
        validationUserTypeAccess(userId);
        driverRepository.deleteById(driverId);
    }

    /**
     * валидация доспута пульзователя
     */
    private void validationUserTypeAccess(Long userId) {
        User validUser = userRepository.getReferenceById(userId);
        log.info("User {}", userId);
        if (validUser.getTypeAccess() != TypeAccess.FULL_ACCESS) {
            //отказ в добавлении водителя не соответствие типа доступа user
            //PARTIAL_ACCESS //частичный доступ
            throw new ValidationBadRequest("Not Access");
        }
    }
}
