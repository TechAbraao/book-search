package com.techabraao.books.demo.controllers;

import com.techabraao.books.demo.dto.request.RequestUsers;
import com.techabraao.books.demo.dto.response.ResponseUsers;
import com.techabraao.books.demo.exceptions.DuplicateDataException;
import com.techabraao.books.demo.exceptions.PasswordsNotMatchException;
import com.techabraao.books.demo.services.UsersService;
import com.techabraao.books.demo.validators.PasswordValidator;
import com.techabraao.books.demo.validators.UsersValidator;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UsersController {

    private final UsersService usersService;
    private final UsersValidator usersValidator;
    private final PasswordValidator passwordValidator;

    @GetMapping
    public String helloWorld() {
        return "Hello, World!";
    }


    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody @Valid RequestUsers requestUser) {

        if (!passwordValidator.passwordsMatches(requestUser.password(), requestUser.confirmPassword())) {
            throw new PasswordsNotMatchException("Passwords do not match. Please check them again.");
        }

        if (usersValidator.verifyUserExists(requestUser.toUserDTO())) {
            throw new DuplicateDataException("Your email or user are already registered. Try different details.");
        }

        usersService.addUser(requestUser);
        ResponseUsers response = new ResponseUsers("User registered successfully", HttpStatus.CREATED.value(), requestUser.toUserDTO());
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);

    }
}
