package com.example.productsservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    @Column(name = "product_name", nullable = false)
    private String productName;
    @Column(name = "price", nullable = false)
    private Double price;
    @Column(name = "category", nullable = false)
    private String category;

}
