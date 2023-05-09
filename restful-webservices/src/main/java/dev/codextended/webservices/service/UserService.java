package dev.codextended.webservices.service;

import dev.codextended.webservices.dto.UserDto;
import dev.codextended.webservices.entity.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user);
    UserDto getUserById(Long id);
    List<UserDto> getAllUsers();
    UserDto updateUser(Long id, UserDto user);
    UserDto deleteUser(Long id);
}
