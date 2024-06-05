package com.ohgiraffers.jpql.section02.parameter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ParameterBidingRepositoryTests {

    @Autowired
    private ParameterBidingRepository parameterBidingRepository;

    @DisplayName("이름 기준 파라미터 바인딩 테스트")
    @Test
    void testParameterBindingByName() {
        String menuName = "한우딸기국밥";
        List<Menu> menuList = parameterBidingRepository.selectMenuByBidingName(menuName);
        assertEquals(menuName, menuList.get(0).getMenuName());
        menuList.forEach(System.out::println);
        System.out.println("menuList = " + menuList);
    }

    @DisplayName("위치 기준 파라미터 바인딩 테스트")
    @Test
    void testParameterBindingByPosition() {
        String menuName = "한우딸기국밥";
        List<Menu> menuList = parameterBidingRepository.selectMenuByBidingPosition(menuName);
        assertEquals(menuName, menuList.get(0).getMenuName());
        menuList.forEach(System.out::println);
        System.out.println("menuList = " + menuList);
    }
}
