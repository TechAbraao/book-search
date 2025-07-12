package com.techabraao.books.demo.controllers;

import com.techabraao.books.demo.dto.request.RequestUsers;
import com.techabraao.books.demo.dto.response.ResponseUsers;
import com.techabraao.books.demo.exceptions.DuplicateDataException;
import com.techabraao.books.demo.services.UsersService;
import com.techabraao.books.demo.validators.UsersValidator;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UsersController {

    private final UsersService service;
    private final UsersValidator validator;

    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody @Valid RequestUsers requestUser) {

        if (validator.verifyUserExists(requestUser.toUserDTO())) {
            throw new DuplicateDataException("Your email or user are already registered. Try different details.");
        }

        service.addUser(requestUser);
        ResponseUsers response = new ResponseUsers(
                "User registered successfully",
                HttpStatus.CREATED.value(),
                requestUser.toUserDTO()
                );
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);

    }
}
