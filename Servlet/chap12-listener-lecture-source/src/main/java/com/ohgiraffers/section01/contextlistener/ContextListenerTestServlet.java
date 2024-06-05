package com.ohgiraffers.section01.contextlistener;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/context")
public class ContextListenerTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("context listener 확인용 서블릿");

        ServletContext context = request.getServletContext();

        /* context에 attr를 추가하면 attributeAdded() 메소드 동작 */
        context.setAttribute("test", "value");

        /* 동일한 key로 context에 attr를 추가하면(수정하면) attributeReplace() 메소드 동작 */
        context.setAttribute("test", "value2");

        /* context에서 attr를 제거하면 attributeRemoved() 메소드 동작 */
        context.removeAttribute("test");
    }
}
