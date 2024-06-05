package com.ohgiraffers.exceptionhandler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExceptionHandlerController {

    @GetMapping("controller-null")
    public String nullPointExceptionTest() {

        String str = null;
        System.out.println(str.charAt(0));

        return "/";
    }

    @ExceptionHandler(NullPointerException.class)
    public String nullPointerExceptionHandler(NullPointerException exception) {

        System.out.println("message = " + exception.getMessage());
        System.out.println("controller 레벨의 exception 처리");

        return "error/nullPointer";
    }

    @GetMapping("controller-user")
    public String userExceptionTest() throws MemberRegistException {
        boolean check = true;
        if (check) {
            throw new MemberRegistException("회원가입 불가능!!!");
        }

        return "/";
    }

    @ExceptionHandler(MemberRegistException.class)
    public String userExceptionHandler(MemberRegistException exception, Model model) {

        model.addAttribute("exception", exception);
        System.out.println("controller 레벨의 exception 처리");

        return "error/memberRegist";
    }
}
