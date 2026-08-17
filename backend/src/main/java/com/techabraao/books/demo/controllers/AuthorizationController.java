package com.techabraao.books.demo.controllers;

import com.techabraao.books.demo.dto.request.RequestLoginUser;
import com.techabraao.books.demo.dto.request.RequestRegisterUser;
import com.techabraao.books.demo.dto.response.LoginResponseDTO;
import com.techabraao.books.demo.dto.response.ResponseUsers;
import com.techabraao.books.demo.exceptions.DuplicateDataException;
import com.techabraao.books.demo.exceptions.PasswordsNotMatchException;
import com.techabraao.books.demo.models.UsersModel;
import com.techabraao.books.demo.services.TokenService;
import com.techabraao.books.demo.services.UsersService;
import com.techabraao.books.demo.validators.PasswordValidator;
import com.techabraao.books.demo.validators.UsersValidator;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthorizationController {

    private final UsersService usersService;
    private final UsersValidator usersValidator;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid RequestLoginUser requestUser) {
        try {
            var usernamePassword = new UsernamePasswordAuthenticationToken(requestUser.email(), requestUser.password());
            try {
                var auth = this.authenticationManager.authenticate(usernamePassword);
                var token = tokenService.generateToken((UsersModel) auth.getPrincipal());
                return ResponseEntity.ok(new LoginResponseDTO(token));
            } catch (BadCredentialsException exception) {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception exception) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", exception.getMessage()));
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RequestRegisterUser requestUser) {

        if (usersValidator.verifyUserExists(requestUser.toUserDTO())) {
            throw new DuplicateDataException("Your email or user are already registered. Try different details.");
        }

        usersService.addUser(requestUser);

        ResponseUsers response = new ResponseUsers("User registered successfully", HttpStatus.CREATED.value(), requestUser.toUserDTO());
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();

    }
}
