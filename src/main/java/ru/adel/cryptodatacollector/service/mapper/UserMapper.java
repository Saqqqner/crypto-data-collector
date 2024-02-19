package ru.adel.cryptodatacollector.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.control.MappingControl;
import org.mapstruct.factory.Mappers;
import ru.adel.cryptodatacollector.controller.dto.RegistrationRequest;
import ru.adel.cryptodatacollector.controller.dto.UserDto;
import ru.adel.cryptodatacollector.model.core.User;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User registrationRequestToUser(RegistrationRequest registrationRequest);
    UserDto userToUserDto(User user);
}
