package com.techabraao.books.demo.dto;
import org.springframework.http.HttpStatus;
import java.util.List;

public record ResponseErrorList(
        int status,
        String message,
        List<ErrorFields> erros
) {
    public static ResponseErrorList badRequest(String message) {
        return new ResponseErrorList(HttpStatus.BAD_REQUEST.value(), message, List.of());
    }
}
