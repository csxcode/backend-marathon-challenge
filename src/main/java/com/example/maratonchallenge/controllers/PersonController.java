package com.example.maratonchallenge.controllers;

import com.example.maratonchallenge.dtos.commons.BaseResponse;
import com.example.maratonchallenge.dtos.commons.PaginationResponse;
import com.example.maratonchallenge.dtos.requests.PaginationPageRequestDto;
import com.example.maratonchallenge.dtos.requests.SunatRucRequestDto;
import com.example.maratonchallenge.dtos.responses.PersonResponseDto;
import com.example.maratonchallenge.dtos.responses.PersonSearchResponseDto;
import com.example.maratonchallenge.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping()
    public ResponseEntity<BaseResponse> search(
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "15") int limit
    ) {
        PaginationPageRequestDto dto = new PaginationPageRequestDto(page, limit);
        PaginationResponse<PersonSearchResponseDto> data = this.personService.search(dto);
        BaseResponse<PaginationResponse<PersonSearchResponseDto>> response = new BaseResponse<>(data, true, "OK");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<BaseResponse> create(@RequestBody SunatRucRequestDto dto) {
        PersonResponseDto data = this.personService.create(dto);
        BaseResponse<PersonResponseDto> response = new BaseResponse<>(data, true, "OK");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
