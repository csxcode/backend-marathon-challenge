package com.example.maratonchallenge.dtos.commons;

public class BaseResponse<T> {
    public T data;
    public boolean success;
    public String message;

    public BaseResponse(T data, boolean success, String message) {
        this.data = data;
        this.success = success;
        this.message = message;
    }
}
