package com.example.maratonchallenge.dtos.commons;

import java.util.List;

public class PaginationResponse<T> {
    public List<T> items;
    public MetaPaginationResponseDto meta;

    public PaginationResponse(List<T> items, MetaPaginationResponseDto meta) {
        this.items = items;
        this.meta = meta;
    }
}