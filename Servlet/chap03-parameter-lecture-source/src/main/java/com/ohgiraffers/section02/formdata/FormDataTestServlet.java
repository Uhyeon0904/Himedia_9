package com.ohgiraffers.section02.formdata;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@WebServlet("/formdata")
public class FormDataTestServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        String name = request.getParameter("name");
//        System.out.println("이름 : " + name);

        Map<String, String[]> requestMap = request.getParameterMap();
        Set<String> keySet = requestMap.keySet();

        Iterator<String> keyIter = keySet.iterator();

        while (keyIter.hasNext()) {
            String key = keyIter.next();
            String[] value = requestMap.get(key);

            System.out.print("key: " + key + ", ");
            for (int i = 0; i < value.length; i++) {
                System.out.print("value [" + i + "]: " + value[i]);
            }
            System.out.println();
        }

        /*  [ Iterator & Enumeration ]
        *   Iterator: 반복자라는 뜻의 인터페이스로 자료를 얻기 위해 사용
        *   - hasNext(): 다음 데이터가 있으면 true, 없으면 false 반환
        *   - next(): 자료 구조의 다음 데이터를 반환
        *   - remove(): 현재 조회하는 객체의 레퍼런스 삭제
        *
        *   Enumeration: Iterator와 유사하게 반복자 역할을 함
        *   - hasMoreElements(): 다음 데이터가 있으면 true, 없으면 false 반환
        *   - nextElement(): 자료 구조의 다음 데이터를 반환  */

        Enumeration<String> names = request.getParameterNames();

        while (names.hasMoreElements()) {
            String key = names.nextElement();
            System.out.println(key);
            String[] value = requestMap.get(key);
            for (String str : value) {
                System.out.println(str);
            }
        }
    }
}
