package dev.codextended.webservices.service.impl;

import dev.codextended.webservices.dto.UserDto;
import dev.codextended.webservices.entity.User;
import dev.codextended.webservices.exception.EmailAlreadyExistsException;
import dev.codextended.webservices.exception.ResourceNotFoundException;
import dev.codextended.webservices.mapper.UserMapstruct;
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
//        User user = userRepository.save(UserMapper.mapDtoToUser(userDto));
        Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());
        if (optionalUser.isPresent()){
            throw new EmailAlreadyExistsException("Email already exists for User");
        }

        User user = userRepository.save(UserMapstruct.INSTANCE.toEntity(userDto));
        return UserMapstruct.INSTANCE.fromEntity(user);
    }

    @Override
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User", "Id", id)
        );
        return UserMapstruct.INSTANCE.fromEntity(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(UserMapstruct.INSTANCE::fromEntity).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(Long id, UserDto user) {
        User userToUpdate = userRepository.findById(user.getId()).orElseThrow(
                () -> new ResourceNotFoundException("User", "Id", id)
        );
        userToUpdate.setFirstname(user.getFirstname());
        userToUpdate.setLastname(user.getLastname());
        userToUpdate.setEmail(user.getEmail());
        return UserMapstruct.INSTANCE.fromEntity(userRepository.save(userToUpdate));
    }

    @Override
    public UserDto deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User", "Id", id)
        );
        userRepository.delete(user);
        return UserMapstruct.INSTANCE.fromEntity(user);
    }
}
