package com.example.maratonchallenge.dtos.requests;

public class PaginationPageRequestDto {

    public int page;
    public int limit;

    public PaginationPageRequestDto(int page, int limit) {
        this.page = page - 1;
        this.limit = limit;
    }
}
