package com.javaapp.ecommerce.model.product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRespository extends JpaRepository<Product, Long> {
    public Product getById(long id);

    public Optional<Product> findById(long id);
}
