package com.example.service1;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("test2")
public class ProfilTest2 implements ProfileTestInteface {
    @Override
    public String getTestName() {
        return "test2";
    }
}
