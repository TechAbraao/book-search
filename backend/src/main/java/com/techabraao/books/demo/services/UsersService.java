package com.techabraao.books.demo.services;

import com.techabraao.books.demo.dto.request.RequestUsers;
import com.techabraao.books.demo.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersService {

    private final UsersRepository repository;

    public void addUser(RequestUsers user) {
       repository.save(user.toUser());
    }

}
