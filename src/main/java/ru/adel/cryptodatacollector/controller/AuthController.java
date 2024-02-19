package ru.adel.cryptodatacollector.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.adel.cryptodatacollector.controller.dto.AuthenticationRequest;
import ru.adel.cryptodatacollector.controller.dto.JWTResponse;
import ru.adel.cryptodatacollector.controller.dto.RegistrationRequest;
import ru.adel.cryptodatacollector.controller.dto.UserDto;
import ru.adel.cryptodatacollector.security.jwt.JWTUtil;
import ru.adel.cryptodatacollector.service.core.AuthService;
import ru.adel.cryptodatacollector.util.exception.UnauthorizedException;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final AuthService authService;
    private final JWTUtil jwtUtil;

    public AuthController(AuthenticationManager authenticationManager, AuthService authService, JWTUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.authService = authService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping(path ="/registration" )
    public ResponseEntity<JWTResponse> performRegistration(@RequestBody RegistrationRequest registrationRequest) {
        UserDto registeredUser = authService.registerUser(registrationRequest);
        String token = jwtUtil.generateToken(registeredUser.getUsername());
        JWTResponse response = new JWTResponse(token);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @PostMapping(path = "/login" )
    public ResponseEntity<JWTResponse> login(@RequestBody AuthenticationRequest authenticationRequest){
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
                    authenticationRequest.getPassword()));
        }catch (AuthenticationException e) {
            throw new UnauthorizedException("Неверно введен логин или пароль");
        }
        String token = jwtUtil.generateToken(authenticationRequest.getUsername());
        JWTResponse response = new JWTResponse(token);
        return ResponseEntity.ok(response);
    }

}
