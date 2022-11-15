package com.aivaz.nurgaliev.itcompany.service;

import com.aivaz.nurgaliev.itcompany.entity.Client;
import com.aivaz.nurgaliev.itcompany.exception.DataNotFoundException;
import com.aivaz.nurgaliev.itcompany.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client getClientById(Integer clientId) throws DataNotFoundException {
        Client client = clientRepository.findByClientId(clientId);

        if (client == null) {
            throw new DataNotFoundException("Client does not exist probably wrong clientId");
        }

        return client;
    }

    public List<Client> getAllClients() throws DataNotFoundException {
        List<Client> clients = clientRepository.findAll();

        if (clients == null) {
            throw new DataNotFoundException("There's no clients in database");
        }

        return clients;
    }
}
