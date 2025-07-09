package com.techabraao.books.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ApiResponse<T> {
    private String message;
    private int status;
    private long total;
    private T data;
}
