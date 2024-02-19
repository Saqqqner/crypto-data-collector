package ru.adel.cryptodatacollector.service.core.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.adel.cryptodatacollector.controller.dto.RegistrationRequest;
import ru.adel.cryptodatacollector.controller.dto.UserDto;
import ru.adel.cryptodatacollector.model.core.User;
import ru.adel.cryptodatacollector.model.core.UserRole;
import ru.adel.cryptodatacollector.repository.core.UserRepository;
import ru.adel.cryptodatacollector.service.core.AuthService;
import ru.adel.cryptodatacollector.service.mapper.UserMapper;
import ru.adel.cryptodatacollector.util.exception.DuplicateUserException;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        userMapper = UserMapper.INSTANCE;
    }

    @Override
    @Transactional
    public UserDto registerUser(RegistrationRequest registrationRequest) {
        if (userRepository.existsByEmail(registrationRequest.getEmail())) {
            throw new DuplicateUserException("Пользователь с указанным именем пользователя уже существует");
        }
        if (userRepository.existsByUsername(registrationRequest.getUsername())) {
            throw new DuplicateUserException("Пользователь с указанным именем пользователя уже существует");
        }
        User user = userMapper.registrationRequestToUser(registrationRequest);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(UserRole.ROLE_USER);
        User savedUser = userRepository.save(user);
        return userMapper.userToUserDto(user);
    }
}
