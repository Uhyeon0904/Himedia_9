
<%-- 지시자 태그, 페이지에 대한 설정 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

<%--    JSP 주석은 클라이언트에게 노출되지 않지만 HTML 주석은 클라이언트에게 노출된다. --%>
    <!-- HTML 주석-->
    <%-- JSP 주석 --%>

    <!-- 선언 태그 -->
    <%!
        private String name;

        private int age;
    %>

    <%-- scriptlet 태그 --%>
    <%
        // 주석 = (자바 주석과 동일하다.)
        // 간단한 자바 코드를 작성할 수 있는 부분이다.
        name = "판다";
        age = 20;
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        
        for (int i = 0; i < name.length(); i++) {
            System.out.println(name.charAt(i));
        }
    %>

    <%-- expression 태그 --%>
    <%-- PrintWriter를 이용하여 브라우저에 값을 내보내 브라우저에서 보여지게 한다. --%>
    name : <%= name %><br>
    age : <%= age %><br>
</head>
<body>

</body>
</html>
