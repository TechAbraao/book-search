package com.techabraao.books.demo.validators;

import com.techabraao.books.demo.dto.response.UsersDTO;
import com.techabraao.books.demo.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UsersValidator {
    private final UsersRepository repository;

    /**
     * Verifica se um usuário já existe no banco de dados com o email e nome fornecidos.
    **/
    public Boolean verifyUserExists(UsersDTO user) {
        return repository.existsByEmail(user.getEmail()) || repository.existsByUsername(user.getUsername());
    }
}
