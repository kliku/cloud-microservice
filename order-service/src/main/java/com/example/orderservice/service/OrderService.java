package com.example.orderservice.service;

import com.example.orderservice.domain.AddOrderForm;
import com.example.orderservice.domain.ItemsDto;
import com.example.orderservice.model.Order;
import com.example.orderservice.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collection;
import java.util.List;


@Service
@AllArgsConstructor
public class OrderService {

    public final OrderRepository orderRepository;

    public final RestTemplate restTemplate;
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElseThrow();
    }

    public void createOrder(AddOrderForm addOrderForm) {
        Order order = new Order();
        order.setUserId(addOrderForm.getUserId());
        order.setPurchasedProductsId(addOrderForm.getProductsId());
        order.setPrice(getPrice(addOrderForm.getProductsId()));
        order.setAddress(getAddress(order.getUserId()));
        orderRepository.save(order);
    }

    private String getAddress(Long id) {
        String url = "http://host.docker.internal:8989/account/user/address/" + id;
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        return responseEntity.getBody();
    }

    private Double getPrice(List<Long> ids) {

        String url = "http://host.docker.internal:8989/products/product/price";
        ResponseEntity<Double> responseEntity = restTemplate.postForEntity(url, new ItemsDto(ids), Double.class);
        return responseEntity.getBody();
    }



}
