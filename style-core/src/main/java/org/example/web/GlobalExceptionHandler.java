package org.example.web;

import org.example.web.exception.InvalidRequestException;
import org.example.web.model.dto.Result;
import org.example.web.model.dto.ResultCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidRequestException.class)
    public ResponseEntity<Result> handleInvalidRequest(InvalidRequestException e) {
        return ResponseEntity
                .badRequest()
                .body(Result.fail(
                        ResultCode.valueOf(e.getCode()),
                        e.getMessage()
                ));
    }

}

