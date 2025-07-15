package com.techabraao.books.demo.services;

import com.techabraao.books.demo.dto.request.RequestRegisterUser;
import com.techabraao.books.demo.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersService {

    private final UsersRepository repository;
    private final PasswordEncoder passwordEncoder;

    public void addUser(RequestRegisterUser user) {
        var passwordHash = passwordEncoder
                .encode(user.password());

       repository.save(user.toUser(passwordHash));
    }

}
