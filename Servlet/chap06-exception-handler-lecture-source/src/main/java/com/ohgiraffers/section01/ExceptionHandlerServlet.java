package com.ohgiraffers.section01;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/showErrorPage")
public class ExceptionHandlerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Enumeration<String> attrName = request.getAttributeNames();
        while (attrName.hasMoreElements()) {
            System.out.println(attrName.nextElement());
        }

        String forwardRequestURI = (String) request.getAttribute("jakarta.servlet.forward.request_uri");
        String contextPath = (String) request.getAttribute("jakarta.servlet.forward.context_path");
        String servletPath = (String) request.getAttribute("jakarta.servlet.forward.servlet_path");
        HttpServletMapping mapping = request.getHttpServletMapping();
        Integer statusCode = (Integer) request.getAttribute("jakarta.servlet.error.status_code");
        String message = (String) request.getAttribute("jakarta.servlet.error.message");
        String servletName = (String) request.getAttribute("jakarta.servlet.error.servlet_name");
        String errorRequestURI = (String) request.getAttribute("jakarta.servlet.error.request_uri");

        System.out.println(forwardRequestURI);
        System.out.println(contextPath);
        System.out.println(servletPath);
        System.out.println(mapping);
        System.out.println(mapping.getServletName());
        System.out.println(mapping.getMatchValue());
        System.out.println(mapping.getPattern());
        System.out.println(mapping.getMappingMatch());
        System.out.println(statusCode);
        System.out.println(message);
        System.out.println(servletName);
        System.out.println(errorRequestURI);

        StringBuilder responseBuilder = new StringBuilder();

        responseBuilder.append("<!doctype html>\n")
                .append("<html>\n")
                .append("<head>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append("<h1>")
                .append(statusCode)
                .append(" - ")
                .append(message)
                .append("</h1>")
                .append("</body>\n")
                .append("</html>\n");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println(responseBuilder.toString());
        out.close();
    }
}
