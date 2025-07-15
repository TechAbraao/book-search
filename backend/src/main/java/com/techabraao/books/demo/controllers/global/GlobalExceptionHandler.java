package com.techabraao.books.demo.controllers.global;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.techabraao.books.demo.dto.ResponseErrorList;
import com.techabraao.books.demo.dto.ErrorFields;
import com.techabraao.books.demo.dto.response.ResponseError;
import com.techabraao.books.demo.exceptions.DuplicateDataException;
import com.techabraao.books.demo.exceptions.EmailNotFoundException;
import com.techabraao.books.demo.exceptions.PasswordsNotMatchException;
import org.hibernate.validator.constraints.Email;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseErrorList handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<FieldError> listErrors = e.getFieldErrors();

        List<ErrorFields> allErrors = listErrors
                .stream()
                .map(fe -> new ErrorFields(fe.getField(), fe.getDefaultMessage()))
                .collect(Collectors.toList());

        return new ResponseErrorList(HttpStatus.UNPROCESSABLE_ENTITY.value(), "Field validation error", allErrors);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseErrorList handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {

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

        return new ResponseErrorList(
                HttpStatus.BAD_REQUEST.value(),
                "Request could not be processed due to invalid value",
                errors
        );
    }

    @ExceptionHandler(DuplicateDataException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseError handleDuplicateDataException(DuplicateDataException e) {

        int status = HttpStatus.CONFLICT.value();
        String message = "E-mail or username is duplicated.";
        String error = e.getMessage();

        return new ResponseError(status, message, error);
    }

    @ExceptionHandler(PasswordsNotMatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseError handlePasswordsNotMatchException(PasswordsNotMatchException e) {
        int status = HttpStatus.BAD_REQUEST.value();
        String message = "The two passwords do not match. Please check and try again.";
        String error = e.getMessage();

        return new ResponseError(status, message, error);
    }

    @ExceptionHandler(EmailNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseError handleEmailNotFoundException(EmailNotFoundException e) {
        int status = HttpStatus.NOT_FOUND.value();
        String message = "There is no record of this email. Please try again with a different email address";
        String error = e.getMessage();

        return new ResponseError(status, message, error);
    }
}
