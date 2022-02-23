package com.example.maratonchallenge.controllers;

import com.example.maratonchallenge.dtos.commons.BaseResponse;
import com.example.maratonchallenge.dtos.requests.LoginRequestDto;
import com.example.maratonchallenge.dtos.responses.LoginResponseDto;
import com.example.maratonchallenge.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<BaseResponse> login(@RequestBody LoginRequestDto dto) {
        LoginResponseDto data = this.userService.login(dto);
        BaseResponse<LoginResponseDto> response = new BaseResponse<>(data, true, "OK");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
