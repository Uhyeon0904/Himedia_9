package com.ohgiraffers.redirect;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("이 서블릿으로 redirect 성공");
        System.out.println(response);

        StringBuilder redirectText = new StringBuilder();

        redirectText.append("<!doctype html>\n")
                .append("<html>\n")
                .append("<head>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append("<h1>Redirect 성공!</h1>")
                .append("</body>\n")
                .append("</html>\n");

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.print(redirectText.toString());

        out.flush();
        out.close();

//        forward는 조회할 때 사용을 권장, 새로 고침하면 재조회해서 추가/삭제된 데이터를 반영해서 조회함

//        redirect는 CURD 사용할 때 권장, 로그인 같은 경우는 select 이지만, redirect 방식을 활용해
//        로그인 횟수 제한 등을 걸기도 함
    }
}
