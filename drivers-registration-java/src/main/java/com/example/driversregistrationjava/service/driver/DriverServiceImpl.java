package com.example.driversregistrationjava.service.driver;

import com.example.driversregistrationjava.model.driver.Driver;
import com.example.driversregistrationjava.model.driver.dto.DriverDto;
import com.example.driversregistrationjava.model.driver.mapper.DriverMapper;
import com.example.driversregistrationjava.model.driver.repository.DriverRepository;
import org.springframework.stereotype.Service;

@Service
public class DriverServiceImpl implements DriverService{

    private final DriverRepository driverRepository;

    private final DriverMapper driverMapper;

    public DriverServiceImpl(DriverRepository driverRepository, DriverMapper driverMapper) {
        this.driverRepository = driverRepository;
        this.driverMapper = driverMapper;
    }

    /**
     * создание водителя
     */
    @Override
    public DriverDto createDriver(DriverDto driverDto) {
        return driverMapper.toDriverDto(driverRepository.save(driverMapper.driverDto(driverDto)));
    }

    /**
     * обновление водителя
     */
    @Override
    public DriverDto updateDriver(DriverDto driverDto, Long driverId) {
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
    public void deleteDriver(Long driverId) {
        driverRepository.deleteById(driverId);
    }
}
