package com.ohgiraffers.interceptor;

import org.springframework.stereotype.Service;

@Service
public class MenuService {

    public void method() {
        System.out.println("MenuService Method 호출 확인");
    }
}
