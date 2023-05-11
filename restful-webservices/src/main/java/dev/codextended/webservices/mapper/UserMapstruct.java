package dev.codextended.webservices.mapper;

import dev.codextended.webservices.dto.UserDto;
import dev.codextended.webservices.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapstruct {

    UserMapstruct INSTANCE = Mappers.getMapper(UserMapstruct.class);

    UserDto fromEntity(User user);

    User toEntity(UserDto userDto);
}
