package com.example.maratonchallenge.services;

import com.example.maratonchallenge.dtos.commons.PaginationResponse;
import com.example.maratonchallenge.dtos.requests.PaginationPageRequestDto;
import com.example.maratonchallenge.dtos.requests.SunatRucRequestDto;
import com.example.maratonchallenge.dtos.responses.PersonResponseDto;
import com.example.maratonchallenge.dtos.responses.PersonSearchResponseDto;

public interface PersonService {
    PaginationResponse<PersonSearchResponseDto> search(PaginationPageRequestDto dto);
    PersonResponseDto create(SunatRucRequestDto dto);
}
