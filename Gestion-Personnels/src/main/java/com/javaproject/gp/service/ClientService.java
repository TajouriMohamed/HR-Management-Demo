package com.javaproject.gp.service;

import com.javaproject.gp.entity.Client;
import com.javaproject.gp.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getClient() {
        return clientRepository.findAll();
    }

    public void create(Client client) {
        clientRepository.save(client);
    }

    public Client updateId(int id) {
        return clientRepository.findById(id).get();
    }


    public void delete(int id) {
        clientRepository.deleteById(id);
    }

}
