package com.example.TestSecurity.controller;


import com.example.TestSecurity.model.TestModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController {

    @PostMapping("/commonsend")
    public TestModel handleCommonPostData(@RequestBody String data) {

        TestModel model1 = new TestModel();
        model1.id = data;
        model1.name = "it's name";

        // 받은 데이터 로깅
        System.out.println("Received data: " + data);

        // 클라이언트에게 응답
        return model1;
    }

    @GetMapping("/welcome")
    public TestModel handleCommonGetData() {

        TestModel model1 = new TestModel();
        model1.id = "it's id";
        model1.name = "it's name";


        // 클라이언트에게 응답
        return model1;
    }
}

