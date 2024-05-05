package com.example.driversregistrationjava.service.user;

import com.example.driversregistrationjava.model.user.dto.UserDto;

public interface UserService {

    UserDto createUser(UserDto userDto);

    UserDto updateUser(UserDto userDto, Long id);

    void deleteUser(Long id);
}
