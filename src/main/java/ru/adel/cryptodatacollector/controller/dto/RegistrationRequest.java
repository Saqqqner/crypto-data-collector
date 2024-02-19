package ru.adel.cryptodatacollector.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class RegistrationRequest {
    private String username;
    private String email;
    private String password;
}
