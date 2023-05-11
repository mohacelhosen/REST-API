package com.mohacel.education.exception;

import com.mohacel.education.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserResourcesNotFoundException.class)
    public ResponseEntity<ApiResponse> resourceNotFoundException(UserResourcesNotFoundException ex){
        String msg = ex.getMessage();
        ApiResponse response =  new ApiResponse(msg,false);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
