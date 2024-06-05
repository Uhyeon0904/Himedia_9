package com.ohgiraffers.jpql.section01.simple;

import jdk.jfr.StackTrace;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertySource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class SimpleJPQLRepositoryTests {

    @Autowired
    private SimpleJPQLRepository simpleJPQLRepository;

    @DisplayName("TypedQuery를 이용한 단일행, 단일 컬럼 조회 테스트")
    @Test
    void testSelectSingleByTypedQuery() {
        String menuName = simpleJPQLRepository.selectSingleMenuByTypedQuery();
        assertEquals("한우딸기국밥", menuName);
    }

    @DisplayName("Query를 이용한 단일 행, 단일 컬럼 조회 테스트")
    @Test
    void testSelectSingleByQuery() {
        Object menuName = simpleJPQLRepository.selectSingleMenuByQuery();
        assertEquals("한우딸기국밥", menuName);
    }

    @DisplayName("TypedQuery를 이용한 단일행 조회 테스트")
    @Test
    void testSelectSingleRowByTypedQuery() {
        Menu menu = simpleJPQLRepository.selectSingleRowByTypedQuery();
        System.out.println("menu = " + menu);
        assertEquals("한우딸기국밥", menu.getMenuName());
    }

    @DisplayName("TypedQuery를 이용한 다중행 조회 테스트")
    @Test
    void testSelectMultiRowByTypedQuery() {
        List<Menu> menuList = simpleJPQLRepository.selectMultiRowByTypedQuery();
        System.out.println("menuList = " + menuList);
        assertNotNull(menuList);
    }

    @DisplayName("Distinct 연산자 사용 조회 테스트(중복제거)")
    @Test
    void testSelectUsingDistinct() {
        List<Integer> categoryList = simpleJPQLRepository.selectUsingDistinct();
        System.out.println("categoryList = " + categoryList);
        assertNotNull(categoryList);
    }

    @DisplayName("IN 연산자 사용 조회 테스트")
    @Test
    void testSelectUsingIn() {
        List<Menu> menuName = simpleJPQLRepository.testSelectUsingIn();
        System.out.println("categoryCodeList = " + menuName);
        assertNotNull(menuName);
    }

    @DisplayName("LIKE 연산자 사용 조회 테스트")
    @Test
    void testSelectUsingLike() {
        List<Menu> menuNameList = simpleJPQLRepository.testSelectUsingLike();
        System.out.println("MenuNameList = " + menuNameList);
        assertNotNull(menuNameList);
    }
}
