package com.javaapp.ecommerce.controller;

import com.javaapp.ecommerce.model.productquantity.Productquantity;
import com.javaapp.ecommerce.service.ProductquantityService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/productquantity")

public class ProductquantityController {
    private ProductquantityService service;

    public ProductquantityController(ProductquantityService service){
        this.service = service;
    }

    @PostMapping("/save")
    @Transactional
    public ResponseEntity save(@RequestBody Productquantity Productquantity, UriComponentsBuilder uriBuilder){
        this.service.save(Productquantity);
        URI uri = uriBuilder.path("/productquantity/{id}").buildAndExpand(Productquantity.getId()).toUri();

        return ResponseEntity.created(uri).body(Productquantity);
    }

    @GetMapping
    public ResponseEntity<List<Productquantity>> listProducquantities(){
        return ResponseEntity.ok(this.service.listProductquantities());
    }

    @GetMapping("/{id}")
    public Productquantity productquantity(@PathVariable Long id){
        return this.service.listProductquantity(id);
    }
}
