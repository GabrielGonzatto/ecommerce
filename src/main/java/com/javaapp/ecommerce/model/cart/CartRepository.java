package com.javaapp.ecommerce.model.cart;

import com.javaapp.ecommerce.model.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository  extends JpaRepository<Cart, Long> {
    public Cart getById(long id);

    public Optional<Cart> findById(long id);
}
