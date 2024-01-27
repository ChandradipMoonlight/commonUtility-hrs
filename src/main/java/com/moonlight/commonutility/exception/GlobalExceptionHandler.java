package com.moonlight.commonutility.exception;

import com.moonlight.commonutility.mappers.AppErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<AppErrors> handleResourceNotFoundException(ResourceNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new AppErrors(e.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<AppErrors> handleMethodArgumentInvalidException(MethodArgumentNotValidException e) {
        Map<String, String> exceptionInfo = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach(objectError -> {
            String fieldName = ((FieldError) objectError).getField();
            exceptionInfo.put(fieldName, objectError.getDefaultMessage());
        });
        return ResponseEntity.badRequest()
                .body(new AppErrors(exceptionInfo));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<AppErrors> handleGlobalException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new AppErrors(e.getMessage()));
    }
}
