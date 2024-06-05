package com.ohgiraffers.jpql.section05.groupfinction;

import com.ohgiraffers.jpql.section05.groupfunction.GroupFunctionRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class GroupFunctionRepositoryTests {

    @Autowired
    private GroupFunctionRepository groupFunctionRepository;

    @DisplayName("특정 카테고리 등록 된 메뉴 수 조회")
    @Test
    void testCountMenuOfCategory() {
        int categoryCode = 555;
        Long countOfMenu = groupFunctionRepository.countMenuOfCategory(categoryCode);
        assertTrue(countOfMenu >= 0);
        System.out.println("countOfMenu = " + countOfMenu);
    }

    @DisplayName("COUNT 외의 다른 그룹 함수 조회 결과가 없는 경우 테스트")
    @Test
    void testOtherWithNoResult() {
        int categoryCode = 555;
//        Long sumOfMenu = groupFunctionRepository.otherWithNoResult(categoryCode);
//        assertTrue(sumOfMenu >= 0);
        assertDoesNotThrow( () -> {
            Long sumOfMenu = groupFunctionRepository.otherWithNoResult(categoryCode);
            System.out.println("sumOfMenu = " + sumOfMenu);
        });
    }

    @DisplayName("HAVING절 조회 테스트")
    @Test
    void testSelectByGroupByHaving() {
//        int minPrice = 50000;
        long minPrice = 50000L;
        List<Object[]> sumPriceOfCategoryList
                = groupFunctionRepository.selectByGroupByHaving(minPrice);
        assertNotNull(sumPriceOfCategoryList);
    }
}
