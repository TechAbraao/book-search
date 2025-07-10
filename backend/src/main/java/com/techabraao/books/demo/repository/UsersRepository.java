package com.techabraao.books.demo.repository;

import com.techabraao.books.demo.models.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsersRepository extends JpaRepository<UsersModel, UUID> {}
