package dev.codextended.webservices.service.impl;

import dev.codextended.webservices.dto.UserDto;
import dev.codextended.webservices.entity.User;
import dev.codextended.webservices.mapper.UserMapper;
import dev.codextended.webservices.repository.UserRepository;
import dev.codextended.webservices.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    @Override
    public UserDto createUser(UserDto userDto) {
        User user = userRepository.save(UserMapper.mapDtoToUser(userDto));
        return UserMapper.mapToUserDto(user);
    }

    @Override
    public UserDto getUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return UserMapper.mapToUserDto(optionalUser.get());
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(Long id, UserDto user) {
        User userToUpdate = userRepository.findById(user.getId()).get();
        userToUpdate.setFirstname(user.getFirstname());
        userToUpdate.setLastname(user.getLastname());
        userToUpdate.setEmail(user.getEmail());
        return UserMapper.mapToUserDto(userRepository.save(userToUpdate));
    }

    @Override
    public UserDto deleteUser(Long id) {
        User user = userRepository.findById(id).get();
        userRepository.delete(user);
        return UserMapper.mapToUserDto(user);
    }
}
