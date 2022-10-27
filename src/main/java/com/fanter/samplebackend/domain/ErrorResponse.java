package com.fanter.samplebackend.domain;

public class ErrorResponse {

    private String error;

    public String getError() {
        return error;
    }

    public ErrorResponse(String message) {
        this.error = message;
    }
}
