package com.techabraao.books.demo.repository;

import com.techabraao.books.demo.models.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsersRepository extends JpaRepository<UsersModel, UUID> {

    Optional<Boolean> findByEmailAndUsername(String email, String username);
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
    Boolean existsByEmailAndUsername(String email, String name);
}
