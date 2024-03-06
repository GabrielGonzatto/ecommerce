package com.javaapp.ecommerce.model.client;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.javaapp.ecommerce.model.cart.Cart;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "client")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String name;

    private String email;

    private String password;

    @OneToMany(mappedBy = "client")
    @JsonIgnore
    private List<Cart> carts;
}
