package com.example.TestSecurity.controller;


import org.springframework.stereotype.Controller;

@Controller
public class MainController {

//    @GetMapping("/")
//    public String mainP(Model model) {
//
//        String id = SecurityContextHolder.getContext().getAuthentication().getName(); // 접속중인 사용자의 id 반환
//
//
//        // 접속중인 사용자의 auth 반환
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
//        Iterator<? extends GrantedAuthority> iter = authorities.iterator();
//        GrantedAuthority auth = iter.next();
//        String role = auth.getAuthority();
//
//
//
//        model.addAttribute("id", id);
//        model.addAttribute("role", role);
//
//        return "main";
//    }
}