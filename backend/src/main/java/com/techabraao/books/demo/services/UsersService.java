package com.techabraao.books.demo.services;

import com.techabraao.books.demo.dto.request.RequestUsers;
import com.techabraao.books.demo.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersService {

    private final UsersRepository repository;
    private final PasswordEncoder passwordEncoder;

    public void addUser(RequestUsers user) {
        var passwordHash = passwordEncoder
                .encode(user.password());

       repository.save(user.toUser(passwordHash));
    }

}
