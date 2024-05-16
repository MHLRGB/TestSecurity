package com.example.TestSecurity.service;


import com.example.TestSecurity.dto.JoinDTO;
import com.example.TestSecurity.entity.UserEntity;
import com.example.TestSecurity.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JoinService {

    private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @Autowired
    private UserRepository userRepository;  // 나중에 생성자 주입 방식 권고

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public void joinProcess(JoinDTO joinDTO) {

        log.info("joinService : joinProcess");

        //db에 이미 동일한 username을 가진 회원이 존재하는지?
        boolean isUser = userRepository.existsByUsername(joinDTO.getUsername());
        if (isUser) {
            log.info("joinProcess : duplicate ID.");
            return;
        }

        // jpa 언어
        UserEntity data = new UserEntity();

        data.setUsername(joinDTO.getUsername());
        data.setPassword(bCryptPasswordEncoder.encode(joinDTO.getPassword())); // 해시 암호화(단방향)
        data.setRole("ROLE_USER"); // 앞에 "ROLE_" 필수


        userRepository.save(data);
    }

    public boolean checkId(String username) {

        boolean isUser2 = userRepository.existsByUsername(username);

        log.info("joinService : checkId : " + isUser2);

        //db에 이미 동일한 username을 가진 회원이 존재하는지?
        return userRepository.existsByUsername(username);
    }
}