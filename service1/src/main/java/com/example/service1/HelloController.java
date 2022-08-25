package com.example.service1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/service1")
@RestController
public class HelloController {

    @Autowired
    private ProfileTestInteface profileTestInteface;

    @GetMapping
    public String getHello() {
        return profileTestInteface.getTestName();
    }
}
