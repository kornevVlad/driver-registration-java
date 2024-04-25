package com.example.driversregistrationjava.service.user;

import com.example.driversregistrationjava.model.admin.User;
import com.example.driversregistrationjava.model.admin.dto.UserDto;
import com.example.driversregistrationjava.model.admin.mapper.UserMapper;
import com.example.driversregistrationjava.model.admin.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    /**
     * Создание пользователя
     */
    @Override
    public UserDto createUser(UserDto userDto) {
        return userMapper.toUserDto(userRepository.save(userMapper.toUser(userDto)));
    }

    /**
     * Обновление данных пользователя
     */
    @Override
    public UserDto updateUser(UserDto userDto, Long id) {
        User user = userRepository.getReferenceById(id);
        User upUser = userMapper.toUser(userDto);
        if (upUser.getName() != null) {
            user.setName(upUser.getName());
        }
        if (upUser.getLastName() != null) {
            user.setLastName(upUser.getLastName());
        }
        if (upUser.getTypeAccess() != null) {
            user.setTypeAccess(upUser.getTypeAccess());
        }
        return userMapper.toUserDto(userRepository.save(user));
    }

    /**
     * Удаление пользователя по ID
     */
    @Override
    public void deleteUser(Long id) { //TODO добавить проверку пользователя в бд по id
        userRepository.deleteById(id);
    }
}
