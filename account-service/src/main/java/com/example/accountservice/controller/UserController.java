package com.example.accountservice.controller;

import com.example.accountservice.model.User;
import com.example.accountservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping(value = "/address/{id}")
    public String getAddressById(@PathVariable Long id) {
        return userService.getUserAddressById(id);
    }
}
