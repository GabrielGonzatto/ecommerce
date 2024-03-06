package com.javaapp.ecommerce.model.cart;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.javaapp.ecommerce.model.client.Client;
import com.javaapp.ecommerce.model.productquantity.Productquantity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "cart")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    double total;

    @ManyToOne
    @JoinColumn(name = "id_client", referencedColumnName = "id")
    private Client client;

    @OneToMany(mappedBy = "cart")
    @JsonIgnore
    private List<Productquantity> productquantities;
}
