package com.ohgiraffers.section03.requestlistener;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class RequestListenerTest implements ServletRequestListener, ServletRequestAttributeListener {

    public RequestListenerTest() {
        System.out.println("request listener 인스턴스 생성!!!");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {

        /* request 인스턴스 소멸 시(응답 완료 후 요청 해제 시) 동작*/
        System.out.println("request 소멸");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("request 생성");
    }

    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        System.out.println("request attribute 추가");
        System.out.println(srae.getName() + " : " + srae.getValue());
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        System.out.println("request attribute 삭제");
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        System.out.println("request attribute 수정");
    }
}
