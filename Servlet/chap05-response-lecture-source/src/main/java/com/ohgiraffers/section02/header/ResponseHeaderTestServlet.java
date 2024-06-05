package com.ohgiraffers.section02.header;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;

@WebServlet("/headers")
public class ResponseHeaderTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        // 1초마다 새로고침 된다.
//        response.setHeader("Refresh", "1");

        // 스트림 생성
        PrintWriter out = response.getWriter();

        long currentTime = System.currentTimeMillis();

        out.println("<h1>" + currentTime + "</h1>");

        out.close();

        // 명시적으로 지정해 주지 않으면 Collection은 Set 인터페이스로 지정된다.
        Collection<String> responseHeader = response.getHeaderNames();
        Iterator<String> iter = responseHeader.iterator();
        while (iter.hasNext()) {
            String headerName = iter.next();
            System.out.println(headerName + ": " + response.getHeaders(headerName));
        }
    }
}
