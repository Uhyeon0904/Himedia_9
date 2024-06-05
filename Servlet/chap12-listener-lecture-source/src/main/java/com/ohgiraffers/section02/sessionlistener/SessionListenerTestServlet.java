package com.ohgiraffers.section02.sessionlistener;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/session")
public class SessionListenerTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        System.out.println("발급 받은 session id: " + session.getId());

        session.setAttribute("username", "panda");
        session.setAttribute("age", 20);
        session.setAttribute("gender", "W");

        session.setAttribute("user", new UserDTO("panda", 20, "W"));

        session.setAttribute("username", "다람쥐");

        session.removeAttribute("gender");

        // 만료 시 모든 attribute를 지운다.
        session.invalidate();
    }
}
