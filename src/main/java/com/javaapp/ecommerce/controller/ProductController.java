package com.javaapp.ecommerce.controller;

import com.javaapp.ecommerce.model.product.Product;
import com.javaapp.ecommerce.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/product")

public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service){
        this.service = service;
    }

    @PostMapping("/save")
    @Transactional
    public ResponseEntity save(@RequestBody Product product, UriComponentsBuilder uriBuilder){
        this.service.save(product);
        URI uri = uriBuilder.path("/product/{id}").buildAndExpand(product.getId()).toUri();

        return ResponseEntity.created(uri).body(product);
    }

    @GetMapping
    public ResponseEntity<List<Product>> listProducts(){
        return ResponseEntity.ok(this.service.listProducts());
    }

    @GetMapping("/{id}")
    public Product product(@PathVariable Long id){
        return this.service.listProduct(id);
    }

}
