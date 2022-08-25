package com.example.service1;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("test1")
public class ProfilTest1 implements ProfileTestInteface{
    @Override
    public String getTestName() {
        return "test1";
    }
}
