package com.prodreadyfeatures.advice;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ApiError {
    private LocalDateTime timestamp;
    private String error;
    private HttpStatus statuscode;

    public ApiError(String error, HttpStatus statuscode) {
        this();
        this.error = error;
        this.statuscode = statuscode;
    }

    public ApiError() {
        this.timestamp = LocalDateTime.now();
    }
}
