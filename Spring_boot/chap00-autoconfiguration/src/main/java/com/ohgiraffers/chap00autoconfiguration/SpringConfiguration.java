package com.ohgiraffers.chap00autoconfiguration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Configuration
public class SpringConfiguration {

    // Application을 바라보고 있어 main 작성을 하지 않아도 실행 가능

    // properties 파일을 읽어오는 어노테이션
    // yml 파일을 더 많이 사용함
    @Value("${test.value}")
    public String value;

    @Value("${test.list}")
    public List<String> list;

    @Value("${test.list}")
    public String[] list2;

    // yml 파일 읽어오는 표현법
    @Value("${test.greeting}")
    private String greeting;

    @Value("${test.array}")
    private Set<String> array;

    /* yml 파일은 키만 입력해도 값을 불러올 수 있다.
    *  우선순위는 환경변수가 더 우선순위다. */
    @Value("${username}")
    private String username;

    @Bean
    public Object propertyReadTest() {
        System.out.println("=============================");
        System.out.println("value = " + value);
        System.out.println("=============================");
        for (String listValue : list) {
            System.out.println("listValue = " + listValue);
        }
        System.out.println("=============================");
        for (String listValue2 : list2) {
            System.out.println("listValue2 = " + listValue2);
        }
        System.out.println("=============================");
        System.out.println("greeting = " + greeting);
        System.out.println("=============================");
        Iterator<String> iter = array.iterator();
        while (iter.hasNext()) {
            System.out.println("iter = " + iter.next());
        }
        System.out.println("=============================");
        System.out.println("username = " + username);
        System.out.println("=============================");
        return new Object();
    }
}
