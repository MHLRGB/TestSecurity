package com.example.TestSecurity.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestReactController {

    @PostMapping("/test")
    public String hello() {
        return "스프링에서 보낸 데이터";
    }
}
