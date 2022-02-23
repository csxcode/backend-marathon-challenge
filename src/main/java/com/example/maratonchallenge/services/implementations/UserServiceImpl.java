package com.example.maratonchallenge.services.implementations;

import com.example.maratonchallenge.dtos.requests.LoginRequestDto;
import com.example.maratonchallenge.dtos.responses.LoginResponseDto;
import com.example.maratonchallenge.exceptions.AuthNotValidException;
import com.example.maratonchallenge.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public LoginResponseDto login(LoginRequestDto dto) {
        if(dto.username.toLowerCase().equals("sysadmin") && dto.password.toLowerCase().equals("sysadmin"))
            return new LoginResponseDto("sysadmin", "Carlos Silva", "Administrator");
        else
            throw new AuthNotValidException("Invalid credentials");
    }
}
