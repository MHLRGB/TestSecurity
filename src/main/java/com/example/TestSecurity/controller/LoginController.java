package com.example.TestSecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginP() {

        return "login";
    }
}

// CustomeUserDetailsService는 DB로부터 특정 username에 대한 데이터를 들고 오고,
// 들고 온 데이터는 CustomUserDetails클래스에 넣어주고 SecurityConfig에 전달하면 검증한 후 페이지 접근 허용

// 사용자가 로그인을 한 뒤 사용자의 정보는 SecurityContextHolder에 의해 관리됨.