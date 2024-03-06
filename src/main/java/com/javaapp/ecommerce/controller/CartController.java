package com.javaapp.ecommerce.controller;

import com.javaapp.ecommerce.model.cart.Cart;
import com.javaapp.ecommerce.model.cart.CartRepository;
import com.javaapp.ecommerce.model.client.Client;
import com.javaapp.ecommerce.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cart")

public class CartController {

    private CartService service;

    public CartController (CartService service){
        this.service = service;
    }

    @PostMapping("/save")
    @Transactional
    public ResponseEntity save(@RequestBody Cart cart, UriComponentsBuilder uriBuilder){
        this.service.save(cart);
        URI uri = uriBuilder.path("/client/{id}").buildAndExpand(cart.getId()).toUri();

        return ResponseEntity.created(uri).body(cart);
    }

    @GetMapping
    public ResponseEntity<List<Cart>> listCarts(){
        return ResponseEntity.ok(this.service.listCarts());
    }

    @GetMapping("/{id}")
    public Cart cart(@PathVariable Long id){
        return this.service.listCart(id);
    }

}
