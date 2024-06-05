package com.ohgiraffers.section01.contextlistener;

import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

// 서블릿에게 Listener라는 것을 알리기 위해 WebListener 어노테이션 적용
@WebListener
public class ContextListenerTest implements ServletContextListener, ServletContextAttributeListener {

    /*  1. context ( -> 톰캣 컨테이너 자체에 리스너 연결 )
    *   - ServletContextListener: 웹 애플리케이션의 시작/종료에 대한 이벤트 리스너
    *   - ServletContextAttributeListener: context에 attribute 추가/수정/삭제에 대한 이벤트 리스너 */
    public ContextListenerTest() {

        System.out.println("context listener 인스턴스 생성");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        // context가 생성 될 때 출력
        System.out.println("context init!!!");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        // context가 소멸 될 때 출력
        System.out.println("context destroy!!!");
    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {

        System.out.println("context attribute 추가!!!");
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        System.out.println("context attribute 삭제!!!");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        System.out.println("context attribute 수정!!!");
    }
}
