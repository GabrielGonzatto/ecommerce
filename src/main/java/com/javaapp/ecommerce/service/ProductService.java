package com.javaapp.ecommerce.service;

import com.javaapp.ecommerce.model.product.Product;
import com.javaapp.ecommerce.model.product.ProductRespository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ProductService {
    private ProductRespository respository;

    public ProductService(ProductRespository respository){
        this.respository = respository;
    }

    public void save (Product product){
        this.respository.save(product);
    }

    public List<Product> listProducts(){
        return this.respository.findAll();
    }

    public Product listProduct(Long id){
        return this.respository.findById(id).get();
    }
}
