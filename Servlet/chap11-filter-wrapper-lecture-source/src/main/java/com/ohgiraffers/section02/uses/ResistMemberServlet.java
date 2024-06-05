package com.ohgiraffers.section02.uses;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/member/resist")
public class ResistMemberServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        String name = request.getParameter("name");

        System.out.println("userId = " + userId);
        System.out.println("password = " + password);
        System.out.println("name = " + name);

        PrintWriter out = response.getWriter();
        out.println("<!doctype html>");
        out.println("<html>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h3>" + name + " 님 가입을 축하 합니다.</h3>");
        out.println("</body>");
        out.println("</html>");

        out.flush();
        out.close();

        /*  암호화: 문자를 암호화 한다.
         *   복호화: 암호화된 문자를 원래 문자로 바꾼다.   */


    }
}
