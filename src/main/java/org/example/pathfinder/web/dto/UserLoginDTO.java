package org.example.pathfinder.web.dto;

import jakarta.validation.constraints.NotBlank;

public class UserLoginDTO {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    public UserLoginDTO() {
    }

    public String getUsername() {
        return username;
    }

    public UserLoginDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserLoginDTO setPassword(String password) {
        this.password = password;
        return this;
    }
}
