package com.techabraao.books.demo.dto;
import org.springframework.http.HttpStatus;
import java.util.List;

public record ApiResponseError(
        int status,
        String message,
        List<ErrorFields> erros
) {
    public static ApiResponseError badRequest(String message) {
        return new ApiResponseError(HttpStatus.BAD_REQUEST.value(), message, List.of());
    }

}
