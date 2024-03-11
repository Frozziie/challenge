package com.example.eldar.exception;

import com.example.eldar.dto.ApiError;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Objects;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CardBrandException.class)
    public ResponseEntity<Object> handleCardBrandException(CardBrandException e) {
        String errorMessage = e.getLocalizedMessage();
        log.error("Error with message: {}", errorMessage);
        ApiError apiError = new ApiError(errorMessage, HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        String errorMessage = Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage();
        log.error("Error with message: {}", errorMessage);
        ApiError apiError = new ApiError(errorMessage, HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.badRequest().body(apiError);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Object> handleNullPointerException(NullPointerException e) {
        String errorMessage = e.getLocalizedMessage();
        log.error("Error with message: {}", errorMessage);
        ApiError apiError = new ApiError(errorMessage, HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.badRequest().body(apiError);
    }
}
