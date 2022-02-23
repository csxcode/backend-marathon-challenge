package com.example.maratonchallenge.services;

import com.example.maratonchallenge.dtos.requests.LoginRequestDto;
import com.example.maratonchallenge.dtos.responses.LoginResponseDto;

public interface UserService {
    LoginResponseDto login(LoginRequestDto dto);
}
