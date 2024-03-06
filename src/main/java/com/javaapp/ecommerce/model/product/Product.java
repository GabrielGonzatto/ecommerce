package com.javaapp.ecommerce.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.javaapp.ecommerce.model.productquantity.Productquantity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String name;

    private String type;

    private String description;

    private Double price;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<Productquantity> productquantities;
}
