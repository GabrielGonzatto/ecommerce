package com.javaapp.ecommerce.service;

import com.javaapp.ecommerce.model.productquantity.Productquantity;
import com.javaapp.ecommerce.model.productquantity.ProductquantityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ProductquantityService {
    private ProductquantityRepository repository;

    public ProductquantityService(ProductquantityRepository repository){
        this.repository = repository;
    }

    public void save (Productquantity productquantity){
        this.repository.save(productquantity);
    }

    public List<Productquantity> listProductquantities(){
        return this.repository.findAll();
    }

    public Productquantity listProductquantity(Long id){
        return this.repository.findById(id).get();
    }
}
