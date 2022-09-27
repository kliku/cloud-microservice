package com.example.productsservice.controller;

import com.example.productsservice.domain.ItemsDto;
import com.example.productsservice.model.Product;
import com.example.productsservice.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products/product")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping(value = "/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping(value = "/price")
    public Double getPriceForProductIds(@RequestBody ItemsDto itemsDto) {
        return productService.getPriceForProductIds(itemsDto);
    }

}
