package dev.codextended.webservices.service;

import dev.codextended.webservices.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUserById(Long id);
    List<User> getAllUsers();
    User updateUser(Long id, User user);
    User deleteUser(Long id);
}
