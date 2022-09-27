package com.example.productsservice.service;

import com.example.productsservice.domain.ItemsDto;
import com.example.productsservice.model.Product;
import com.example.productsservice.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow();
    }

    public Double getPriceForProductIds(ItemsDto itemsDto) {

        List<Product> productList = productRepository.findAllById(itemsDto.getIds());
        return productList.stream().mapToDouble(Product::getPrice).sum();
    }
}
