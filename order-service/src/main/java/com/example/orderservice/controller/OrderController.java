package com.example.orderservice.controller;

import com.example.orderservice.domain.AddOrderForm;
import com.example.orderservice.model.Order;
import com.example.orderservice.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping(value = "/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @PostMapping
    public void createOrder(@RequestBody AddOrderForm addOrderForm) {
        orderService.createOrder(addOrderForm);
    }
}
