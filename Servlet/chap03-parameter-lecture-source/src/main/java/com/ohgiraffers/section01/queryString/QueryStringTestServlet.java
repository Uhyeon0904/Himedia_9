package com.ohgiraffers.section01.queryString;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

/*  <form action="querystring" method="get">: action의 이름 적기    */
@WebServlet("/querystring")
public class QueryStringTestServlet extends HttpServlet {

    /*  톰캣 서블릿 컨테이너가 요청 url로 매핑 된 서블릿 클래스의 인스턴스를 생성하여, 서비스 메소드를 호출하고
    * Http 서블릿을 상속 받아 오버라이딩 한 현재 클래스의 doGet 메소드가 동적 바인딩에 의해 호출 된다.  */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*  input 태그의 "name" 속성의 값이 "name"인 값을 가지고 온다.    */
        String name = request.getParameter("name");
        System.out.println("이름 : " + name);

        /*  getPrameter는 String으로 반환하기 때문에 int로 반환 받으려면 형변환을 해줘야 한다.    */
        int age = Integer.parseInt(request.getParameter("age"));
        System.out.println("나이 : " + age);

        java.sql.Date birthday = java.sql.Date.valueOf(request.getParameter("birthday"));
        System.out.println("생일 : " + birthday);

        String gender = request.getParameter("gender");
        System.out.println("성별 : " + gender);

        String national = request.getParameter("national");
        System.out.println("국적 : " + national);

        /*  체크박스는 값이 두 개 이상이기 때문에 배열로 취급되서 request.getParameterValues를 사용한다.    */
        String[] hobbies = request.getParameterValues("hobbies");
        /*  배열의 출력이기 때문에 for문을 이용한다.    */
        for (String hobbie : hobbies) {
            System.out.println(hobbie + ", ");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
