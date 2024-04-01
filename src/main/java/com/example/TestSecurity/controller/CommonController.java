package com.example.TestSecurity.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class CommonController {
    @PostMapping("/common")
    public String handleCommonData(@RequestBody String data) {
        // YourDataObject에는 클라이언트가 보낸 데이터 구조에 맞는 POJO 클래스를 사용해야 합니다.
        // 여기서는 예시로 YourDataObject라는 이름을 사용하였습니다.

        // 받은 데이터 로깅
        System.out.println("Received data: " + data);

        // 클라이언트에게 응답
        return "Data received successfully!";
    }
}

