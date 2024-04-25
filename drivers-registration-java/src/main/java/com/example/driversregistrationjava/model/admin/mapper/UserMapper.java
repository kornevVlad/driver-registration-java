package com.example.driversregistrationjava.model.admin.mapper;

import com.example.driversregistrationjava.model.admin.User;
import com.example.driversregistrationjava.model.admin.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto toUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setLastName(user.getLastName());
        userDto.setTypeAccess(user.getTypeAccess());
        return userDto;
    }

    public User toUser(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setLastName(userDto.getLastName());
        user.setTypeAccess(userDto.getTypeAccess());
        return user;
    }
}
