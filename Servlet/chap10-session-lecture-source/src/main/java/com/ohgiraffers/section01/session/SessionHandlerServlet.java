package com.ohgiraffers.section01.session;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/session")
public class SessionHandlerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        System.out.println("firstName = " + firstName);
        System.out.println("lastName = " + lastName);

        // HttpSession은 인터페이스 이기 때문에 getSession을 꼭 사용해줘야만 반환 받을 수 있다.
        // Cookie는 인터페이스가 아니여서 new Cookie로 객체를 생성할 수 있었다.
        /*  HttpSession은 직접 생성할 수 없고 request에 있는 getSession 메소드를 이용해 리턴 받는다.    */
        HttpSession session = request.getSession();

        System.out.println("session id = " + session.getId());

        // 기본 유지 시간 30분, 1800초
        System.out.println("session default 유지 시간 = " + session.getMaxInactiveInterval());

        // 유지 시간 설정, 1분 설정
        session.setMaxInactiveInterval(1200);

        System.out.println("변경 후 유지 시간 = " + session.getMaxInactiveInterval());

        // session의 값을 setAttribute를 사용해 값을 넣는다.
        session.setAttribute("firstName", firstName);
        session.setAttribute("lastName", lastName);

        // 리다이렉트를 하기 위해 경로를 지정해 준다.
        response.sendRedirect("redirect");
    }
}
