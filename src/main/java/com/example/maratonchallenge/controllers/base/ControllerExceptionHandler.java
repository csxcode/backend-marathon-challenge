package com.example.maratonchallenge.controllers.base;

import com.example.maratonchallenge.dtos.commons.BaseResponse;
import com.example.maratonchallenge.exceptions.AuthNotValidException;
import com.example.maratonchallenge.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice()
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<BaseResponse> handleInternalError(Exception ex, WebRequest request) {
        return new ResponseEntity<>(new BaseResponse(null, false, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<BaseResponse> handleGenericException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(new BaseResponse(null, false, ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {AuthNotValidException.class})
    public ResponseEntity<BaseResponse> handleAuthException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(new BaseResponse(null, false, ex.getMessage()), HttpStatus.BAD_REQUEST);
    }
}