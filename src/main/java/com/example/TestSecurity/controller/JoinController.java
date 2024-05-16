package com.example.TestSecurity.controller;

import com.example.TestSecurity.dto.JoinDTO;
import com.example.TestSecurity.service.JoinService;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JoinController {
    private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @Autowired
    private JoinService joinService; // 현재 필드 주입으로 선언했지만, 생성자 주입 방식 권고

//    @GetMapping("/join")
//    public String joinP() {
//
//        return "join";
//    }

    @GetMapping("/joinProc")
    public String joinProcess(JoinDTO joinDTO) {
        log.info("joinController : joinProcess");
        // System.out.println(joinDTO.getUsername());

        joinService.joinProcess(joinDTO);

        return "redirect:/login";
    }

    @ResponseBody
    @PostMapping("/checkid")
    public String checkId(@RequestBody String requestBody) {
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(requestBody);

            // "username" 키에 해당하는 값을 추출
            String username = (String) jsonObject.get("username");


            if(joinService.checkId(username)) {
                return "F";
            } else {
                return "T";
            }


        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
            return "Error";
        }

    }
}

// join.mustache에서 보내준 폼을 JoinController가 Post방식으로 매핑하여 받아 DTO를 생성하여 JoinService로 넘겨주고,
// JoinService에서 해당 데이터의 username을 확인하고, 존재하지 않으면, DTO객체를 Entity 객체로 바꾼 후 회원정보를 테이블에 저장.
// "/join", "/joinProc" 경로를 모든 사용자가 접근할 수 있도록 SecurityConfig에서 설정.