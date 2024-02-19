package ru.adel.cryptodatacollector.controller.dto;

public class UserDto {
    private String username;
    private String email;

    public UserDto(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public UserDto() {
    }


    public String getUsername() {
        return this.username;
    }

    public String getEmail() {
        return this.email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return "UserDto(username=" + this.getUsername() + ", email=" + this.getEmail() + ")";
    }
}
