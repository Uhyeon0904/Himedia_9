package com.ohgiraffers.cookie;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.Map;

@WebServlet("/cookie")
public class CookieHandlerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        System.out.println("firstName = " + firstName);
        System.out.println("lastName = " + lastName);

//        sendRedirect는 기본적으로 method가 "get" 방식이다.
//        response.sendRedirect("redirect");

        /*  [ 쿠키 사용법 ]
        *   1. 쿠키를 생성한다.
        *   2. 생성한 쿠키의 만료 시간을 설정한다.
        *   3. 응답 헤더에 쿠키를 담는다.
        *   4. 응답을 보낸다.
        *
        *   쿠키의 제약 사항
        *   이름은 ASCII 문자만을 사용해야 하며 한 번 설정한 이름은 변경 불가
        *   이름에 공백 문자와 일부 특수문자([ ] ( ) = , " \ ? @ : ;) 사용 불가   */

        // 쿠키를 생성할 때는 키, 값을 넣어줘야 한다.
        Cookie firstNameCookie = new Cookie("firstName", firstName);
        Cookie lastNameCookie = new Cookie("lastName", lastName);

        // 초 단위로 설정, (하루를 만료로 설정)
        firstNameCookie.setMaxAge(60 * 60 * 24);
        lastNameCookie.setMaxAge(60 * 60 * 24);

        // 응답 헤더에 쿠키 담기
        response.addCookie(firstNameCookie);
        response.addCookie(lastNameCookie);

        response.sendRedirect("redirect");
    }
}