package com.ohgiraffers.associationmapping.section03.bidirection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BiDirectionServiceTests {

    @Autowired
    private BiDirectionService biDirectionService;

    @DisplayName("양방향 영관 관계 매핑 조회 테스트(연관 관계의 주인")
    @Test
    void biDirectionFindTest1() {
        // given
        int menuCode = 10;
        // when
        /* 진짜 연관 관계: 처음 조회 시 부터 조인한 결과를 인출해 온다.(즉시 로딩) */
        Menu foundMenu = biDirectionService.findMenu(menuCode);
        // then
        assertEquals(menuCode, foundMenu.getMenuCode());
    }

    @DisplayName("양방향 영관 관계 매핑 조회 테스트(연관 관계의 주인")
    @Test
    void biDirectionFindTest2() {
        // given
        int categoryCode = 10;
        // when
        /* 가짜 연관 관계: 해당 엔티티를 조회하고 필요 시 연관 관계 엔티티를 조회하는 쿼리를 실행(지연 로딩) */
        Category foundCategory = biDirectionService.findCategory(categoryCode);
        // then
        assertEquals(categoryCode, foundCategory.getCategoryCode());
    }
}
