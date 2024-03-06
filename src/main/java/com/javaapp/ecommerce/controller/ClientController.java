package com.javaapp.ecommerce.controller;

import com.javaapp.ecommerce.model.client.Client;
import com.javaapp.ecommerce.model.product.Product;
import com.javaapp.ecommerce.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/client")

public class ClientController {
    private final ClientService service;

    public ClientController (ClientService service){
        this.service = service;
    }

    @PostMapping("/save")
    @Transactional
    public ResponseEntity save(@RequestBody Client client, UriComponentsBuilder uriBuilder){
        this.service.save(client);
        URI uri = uriBuilder.path("/client/{id}").buildAndExpand(client.getId()).toUri();

        return ResponseEntity.created(uri).body(client);
    }

    @GetMapping
    public ResponseEntity<List<Client>> listClients(){
        return ResponseEntity.ok(this.service.listClients());
    }

    @GetMapping("/{id}")
    public Client client(@PathVariable Long id){
        return this.service.listClient(id);
    }
}
