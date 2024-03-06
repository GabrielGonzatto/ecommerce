package com.javaapp.ecommerce.model.client;

import com.javaapp.ecommerce.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    public Client getById(long id);

    public Optional<Client> findById(long id);
}
