package com.techabraao.books.demo.controllers.global;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.techabraao.books.demo.dto.ApiResponseError;
import com.techabraao.books.demo.dto.ErrorFields;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ApiResponseError handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<FieldError> listErrors = e.getFieldErrors();


        List<ErrorFields> allErrors = listErrors
                .stream()
                .map(fe -> new ErrorFields(fe.getField(), fe.getDefaultMessage()))
                .collect(Collectors.toList());

        return new ApiResponseError(HttpStatus.UNPROCESSABLE_ENTITY.value(), "Field validation error", allErrors);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponseError handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {

        String field = "unknown";
        String detailMessage = e.getMostSpecificCause().getMessage();

        if (e.getCause() instanceof InvalidFormatException invalidFormat) {
            if (!invalidFormat.getPath().isEmpty()) {
                field = invalidFormat.getPath().get(0).getFieldName();
            }
        }

        List<ErrorFields> errors = List.of(
                new ErrorFields(field, "Invalid selected value. Choose one of the defined constant values")
        );

        return new ApiResponseError(
                HttpStatus.BAD_REQUEST.value(),
                "Request could not be processed due to invalid value",
                errors
        );
    }



}
