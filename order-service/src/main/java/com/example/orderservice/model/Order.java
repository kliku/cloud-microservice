package com.example.orderservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    @Column(name = "user_id", nullable = false)
    private Long userId;
    @ElementCollection(targetClass = Long.class)
    @JoinTable(name = "purchased_products", joinColumns = @JoinColumn(name = "order_id"))
    @Column(name = "product_id")
    private List<Long> purchasedProductsId;
    @Column(name = "price", nullable = false)
    private Double price;
    @Column(name = "address", nullable = false)
    private String address;
}
