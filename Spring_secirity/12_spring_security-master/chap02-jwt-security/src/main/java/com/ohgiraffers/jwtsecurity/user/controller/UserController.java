package com.ohgiraffers.jwtsecurity.user.controller;

import com.ohgiraffers.jwtsecurity.user.entity.User;
import com.ohgiraffers.jwtsecurity.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.Objects;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    /* 실무에서는 User가 아닌 DTO를 넣어서 변환 하기 */
    public String signup(@RequestBody User user) {
        user.setUserPass(passwordEncoder.encode(user.getUserPass()));
        user.setState("Y");
        User value = userRepository.save(user);

        if (Objects.isNull(value)) {
            return "회원 가입 실패";
        } else {
            return "회원 가입 성공!";
        }
    }
}
