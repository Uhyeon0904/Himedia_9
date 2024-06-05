package com.ohgiraffers.resolver;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping(value = {"/", "/main"})
    public String main() {
        return "main";
        // view에 물리적인 이름 설정 가능
    }
}
