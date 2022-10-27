package com.fanter.samplebackend.exceptions;

import com.fanter.samplebackend.domain.ErrorResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    @ResponseStatus(value= HttpStatus.BAD_REQUEST)
    public ErrorResponse handleException(Exception e) {
        return new ErrorResponse(e.getMessage());
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(AddUserException.class)
    @ResponseStatus(value= HttpStatus.BAD_REQUEST)
    public ErrorResponse handleAddUserException(AddUserException e) {
        return new ErrorResponse(e.getMessage());
    }
}
