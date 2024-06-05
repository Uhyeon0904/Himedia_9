package com.ohgiraffers.section02.crud;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EntityManagerCRUDTests {

    private EntityManagerCRUD crud;

    /* 각 테스트 메소드 실행 전에 EntityManagerCRUD 객체를 새로 생성 */
    @BeforeEach
    void initManager() {
        this.crud = new EntityManagerCRUD();
    }

    @DisplayName("메뉴 코드로 메뉴 조회 테스트")
    /* ParameterizedTest: 같은 메소드나 기능에 대해 여러 번 테스트를 실행하는 경우 사용 */
    @ParameterizedTest
    @CsvSource({"2, 2", "3, 3"})
    void testFindMethodByMenuCode(int menuCode, int expected) {
        //given
        // when
        Menu foundMenu = crud.findMenuByMenuCode(menuCode);
        // then
        assertEquals(expected, foundMenu.getMenuCode());
        System.out.println("@@@@@@@@@@@@@foundMenu = " + foundMenu);
    }

    private static Stream<Arguments> newMenu() {
        return Stream.of(
                Arguments.of(
                        "신메뉴",
                        35000,
                        4,
                        "Y"
                )
//                Arguments.of(
//                        "신메뉴",
//                        35000,
//                        4,
//                        "Y"
//                ) @@@@@@@@@@@@@@@@@@@여러 개 사용 가능
        );
    }

    @DisplayName("새로운 메뉴 추가 테스트")
    @ParameterizedTest
    /* @MethodSource: newMenu 메소드를 호출해서 반환 받은 값들을 파라미터에 사용하겠다. */
    @MethodSource("newMenu")
    void testRegist(String menuName, int menuPrice, int categoryCode, String orderableStatus) {
        // when
        Menu newMenu = new Menu(menuName, menuPrice, categoryCode, orderableStatus);
        Long count = crud.saveAndReturnAllCount(newMenu);

        // then
        assertEquals(44, count);
    }

    @DisplayName("메뉴 이름 수정 테스트")
    @ParameterizedTest
    @CsvSource("2, 변경 된 이름")
    void testModifyMenuName(int menuCode, String menuName) {
        // when
        Menu modifiedMenu = crud.modifyMenuName(menuCode, menuName);
        // then
        assertEquals(menuName, modifiedMenu.getMenuName());
    }

    @DisplayName("메뉴 삭제 테스트")
    @ParameterizedTest
    /* int 이지만 ints로 사용하라고 명시함(ctrl + click)
    * ints: 삭제할 메뉴 코드 값 */
    @ValueSource(ints = {119,120,121,122,123,124})
    void testRemoveMenu(int menuCode) {
        // when
        Long count = crud.removeAndReturnAllCount(menuCode);
        /* expected: 현재 행에서 삭제 할 행의 수를 뺀 예상 값 (44 - 9) */
//        assertEquals(35, count);
    }
}
