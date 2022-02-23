package com.example.maratonchallenge.controllers;

import com.example.maratonchallenge.dtos.commons.BaseResponse;
import com.example.maratonchallenge.dtos.responses.SunatRucResponseDto;
import com.example.maratonchallenge.exceptions.NotFoundException;
import com.example.maratonchallenge.providers.SunatProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sunat")
public class SunatController {

    private SunatProvider sunatProvider;

    @Autowired
    public SunatController(SunatProvider sunatProvider){
        this.sunatProvider = sunatProvider;
    }

    @GetMapping("/ruc/{number}")
    public ResponseEntity<BaseResponse<SunatRucResponseDto>> getDataByRucNumber(@PathVariable String number) {
        SunatRucResponseDto data = this.sunatProvider.getRuc(number);
        BaseResponse<SunatRucResponseDto> response = new BaseResponse<>(data,true, "OK");

        if(data.getRuc() == null){
            throw new NotFoundException("Ruc entered does not exists in Sunat");
        } else
            return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
