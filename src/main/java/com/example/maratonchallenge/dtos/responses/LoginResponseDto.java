package com.example.maratonchallenge.dtos.responses;

public class LoginResponseDto {
    public String user_name;
    public String full_name;
    public String role_name;

    public LoginResponseDto(String username, String fullName, String roleName){
        this.user_name = username;
        this.full_name = fullName;
        this.role_name = roleName;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }
}
