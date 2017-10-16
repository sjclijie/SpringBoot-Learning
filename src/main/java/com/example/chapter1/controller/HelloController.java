package com.example.chapter1.controller;

import com.example.chapter1.properties.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private User user;

    @GetMapping(value = "/")
    public String index() {
        return user.getName() + user.getAge();
    }
}
