package com.example.accountservice.service;

import com.example.accountservice.model.User;
import com.example.accountservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User getUserById(Long id) {
       return userRepository.findById(id).orElseThrow();
    }
}
