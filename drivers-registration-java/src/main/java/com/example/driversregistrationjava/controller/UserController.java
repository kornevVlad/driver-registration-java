package com.example.driversregistrationjava.controller;

import com.example.driversregistrationjava.model.admin.dto.UserDto;
import com.example.driversregistrationjava.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;


    @PostMapping() //создание пользователя
    public UserDto createUser(@RequestBody UserDto userDto) {
        log.info("User {}", userDto);
        return userService.createUser(userDto);
    }

    //TODO добавить проверку пользователя
    @PatchMapping("/{userId}") //обновление пользователя
    public UserDto updateUser(@RequestBody UserDto userDto, @PathVariable Long userId) {
        log.info("User {}, id {}", userDto, userId);
        return userService.updateUser(userDto, userId);
    }

    //TODO добавить проверку пользователя
    @DeleteMapping("/{userId}") //удаление пользователя
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }
}