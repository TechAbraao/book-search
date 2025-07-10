package com.techabraao.books.demo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseUsers {
    private String message;
    private int status;
    private UsersDTO data;
}
