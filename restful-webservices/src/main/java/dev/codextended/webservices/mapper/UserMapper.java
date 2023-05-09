package dev.codextended.webservices.mapper;

import dev.codextended.webservices.dto.UserDto;
import dev.codextended.webservices.entity.User;

public class UserMapper {
    public static UserDto mapToUserDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .build();
    }

    public static User mapDtoToUser(UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getFirstname(),
                userDto.getLastname(),
                userDto.getEmail()
        );
    }
}
