package org.example.pathfinder.service.dto;

import org.example.pathfinder.model.Level;

public class UserProfileDTO {

    private String username;
    private String fullName;
    private int age;
    private Level level;

    public String getUsername() {
        return username;
    }

    public UserProfileDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserProfileDTO setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public int getAge() {
        return age;
    }

    public UserProfileDTO setAge(int age) {
        this.age = age;
        return this;
    }

    public Level getLevel() {
        return level;
    }

    public UserProfileDTO setLevel(Level level) {
        this.level = level;
        return this;
    }
}
