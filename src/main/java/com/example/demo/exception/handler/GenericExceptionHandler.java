package com.example.demo.exception.handler;

import com.example.demo.exception.ElementAlreadyExistsException;
import com.example.demo.exception.ElementNotFoundExeption;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GenericExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = ElementNotFoundExeption.class)
    private ResponseEntity<ErrorResponse> handeException(ElementNotFoundExeption exception) {
        ErrorResponse errorResponse = new ErrorResponse("element not found",404);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = ElementAlreadyExistsException.class)
    private ResponseEntity<ErrorResponse> handeException(ElementAlreadyExistsException exception) {
        ErrorResponse errorResponse = new ErrorResponse("element already exists",HttpStatus.CONFLICT.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }
}
