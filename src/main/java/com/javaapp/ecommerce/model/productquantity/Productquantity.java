package com.javaapp.ecommerce.model.productquantity;

import com.javaapp.ecommerce.model.cart.Cart;
import com.javaapp.ecommerce.model.product.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "productquantity")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Productquantity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "id_cart", referencedColumnName = "id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "id_product", referencedColumnName = "id")
    private Product product;
}
