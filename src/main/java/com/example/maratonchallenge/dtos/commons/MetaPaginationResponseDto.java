package com.example.maratonchallenge.dtos.commons;

public class MetaPaginationResponseDto {
    public int current_page;
    public int items_per_page;
    public int total_items;
    public int total_pages;

    public MetaPaginationResponseDto(int current_page, int items_per_page, int total_items, int total_pages) {
        this.current_page = current_page;
        this.items_per_page = items_per_page;
        this.total_items = total_items;
        this.total_pages = total_pages;
    }
}
