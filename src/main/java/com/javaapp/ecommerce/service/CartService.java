package com.javaapp.ecommerce.service;

import com.javaapp.ecommerce.model.cart.Cart;
import com.javaapp.ecommerce.model.cart.CartRepository;
import com.javaapp.ecommerce.model.product.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CartService {
    private CartRepository repository;

    public CartService (CartRepository repository){
        this.repository = repository;
    }

    public void save (Cart cart){
        this.repository.save(cart);
    }

    public List<Cart> listCarts(){
        return this.repository.findAll();
    }

    public Cart listCart(Long id){
        return this.repository.findById(id).get();
    }
}
