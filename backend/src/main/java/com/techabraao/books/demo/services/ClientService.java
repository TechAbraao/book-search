package com.techabraao.books.demo.services;

import com.techabraao.books.demo.models.ClientModel;
import com.techabraao.books.demo.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClienteRepository repository;

    public ClientModel save(ClientModel client) {
        return repository.save(client);
    }
    public ClientModel getByClientID(String clientId) {
        return repository.findByClientId(clientId);
    }
}
