package com.javaapp.ecommerce.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.javaapp.ecommerce.model.client.Client;
import com.javaapp.ecommerce.model.client.ClientRepository;
import jakarta.persistence.OneToMany;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class ClientService {
    private ClientRepository respository;

    public ClientService(ClientRepository respository){
        this.respository = respository;
    }

    public void save (Client client){
        this.respository.save(client);
    }

    public List<Client> listClients(){
        return this.respository.findAll();
    }

    public Client listClient(Long id){
        return this.respository.findById(id).get();
    }
}
