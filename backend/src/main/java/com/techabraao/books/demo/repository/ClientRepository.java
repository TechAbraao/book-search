package com.techabraao.books.demo.repository;

import com.techabraao.books.demo.models.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<ClientModel, UUID> {
    ClientModel findByClientId(String clientId);
}
