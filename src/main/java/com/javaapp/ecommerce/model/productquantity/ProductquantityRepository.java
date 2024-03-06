package com.javaapp.ecommerce.model.productquantity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductquantityRepository extends JpaRepository<Productquantity, Long> {
    public Productquantity getById(long id);

    public Optional<Productquantity> findById(long id);
}
