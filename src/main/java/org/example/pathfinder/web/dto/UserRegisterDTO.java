package org.example.pathfinder.web.dto;

import jakarta.validation.constraints.*;
import org.example.pathfinder.model.Level;
import org.example.pathfinder.validation.annotation.UniqueEmail;
import org.example.pathfinder.validation.annotation.UniqueUsername;
import org.example.pathfinder.validation.annotation.ValidatePasswords;

@ValidatePasswords
public class UserRegisterDTO {

    @NotBlank
    @Size(min = 2, max = 200)
    @UniqueUsername
    private String username;

    @NotEmpty
    @Size(min = 5, max = 200)
    private String fullName;

    @Email(regexp = ".*@.*")
    @UniqueEmail
    private String email;

    @Min(1)
    @Max(90)
    @NotNull
    private Integer age;

    @Size(min = 5, max = 100)
    private String password;

    private String confirmPassword;

    private Level level;

    public Level getLevel() {
        return level;
    }

    public UserRegisterDTO setLevel(Level level) {
        this.level = level;
        return this;
    }

    public UserRegisterDTO() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
