package ru.adel.cryptodatacollector.service.core;


import ru.adel.cryptodatacollector.controller.dto.RegistrationRequest;
import ru.adel.cryptodatacollector.controller.dto.UserDto;

public interface AuthService {
    UserDto registerUser(RegistrationRequest registrationRequest);

}
