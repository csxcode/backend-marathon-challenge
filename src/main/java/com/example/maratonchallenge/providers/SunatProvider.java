package com.example.maratonchallenge.providers;

import com.example.maratonchallenge.dtos.responses.SunatRucResponseDto;

public interface SunatProvider {
    SunatRucResponseDto getRuc(String rucNumber);
}
