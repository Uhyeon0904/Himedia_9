package com.ohgiraffers.jwtsecurity.auth.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/*
 * CORS 설정을 위한 filter 설정 클래스
 * 위조사이트 공격 막는 필터
 * */
public class HeaderFilter implements Filter {

    @Override
    /* doFilter 강제 오버라이딩 */
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        /* 밑에 코드 CORS 설정 */
        /* 다른 외부 요청의 응답을 허용할 것인가? */
        res.setHeader("Access-Control-Allow-Origin", "*");
        /* 외부 요청에 허용할 메서드 */
        res.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
        /* 캐싱을 허용할 시간(3600초 = 1시간) */
        res.setHeader("Access-Control-Max-Age", "3600");
        /* 요청 시 허용할 header 타입 */
        res.setHeader("Access-Control-Allow-Headers",
                "X-Requested-With, Content-Type, Authorization, X-XSRF-token");
        /* 자격 증명을 허용할 것인가? */
        res.setHeader("Access-Control-Allow-Credentials", "false");

        filterChain.doFilter(servletRequest, res);
    }
}
