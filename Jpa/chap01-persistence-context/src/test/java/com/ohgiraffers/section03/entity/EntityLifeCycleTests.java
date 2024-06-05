package com.ohgiraffers.section03.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class EntityLifeCycleTests {

    private EntityLifeCycle lifeCycle;

    /* 테스트를 실행할 때 마다 객체를 새로 만든다. */
    @BeforeEach
    void setUp() {
        this.lifeCycle = new EntityLifeCycle();
    }

    @DisplayName("비영속 테스트")
    @ParameterizedTest
    @ValueSource(ints = {2, 3})
    void testTransient(int menuCode) {
        // when
        Menu foundMenu = lifeCycle.findMenuByMenuCode(menuCode);
        Menu newMenu = new Menu(
                foundMenu.getMenuCode(),
                foundMenu.getMenuName(),
                foundMenu.getMenuPrice(),
                foundMenu.getCategoryCode(),
                foundMenu.getOrderableStatus()
        );
        EntityManager entityManager = lifeCycle.getManagerInstance();

        // then
        assertNotEquals(foundMenu, newMenu);
        /* contains: 파라미터 값을 포함하고 있는지? */
        // foundMenu는 영속성 컨텍스트에서 관리되는 영속 상태의 객체
        assertTrue(entityManager.contains(foundMenu));
        // newMenu는 영속성 컨텍스트에서 관리 되지 않는 비영속 상태의 객체
        assertFalse(entityManager.contains(newMenu));
        System.out.println("@@@@@@@@@@@@foundMenu = " + foundMenu.hashCode());
        System.out.println("@@@@@@@@@@@@newMenu = " + newMenu.hashCode());
    }

    @DisplayName("다른 엔티티 매니저가 관리하는 엔티티의 영속성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {2, 3})
    void testManagedOtherEntityManager(int menuCode) {
        // when
        Menu menu1 = lifeCycle.findMenuByMenuCode(menuCode);
        Menu menu2 = lifeCycle.findMenuByMenuCode(menuCode);
        // then
        assertNotEquals(menu1, menu2);
    }

    @DisplayName("같은 엔티티 매니저가 관리하는 엔티티의 영속성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {2, 3})
    void testManagedSameEntityManager(int menuCode) {
        // when
        EntityManager entityManager = EntityManagerGenerator.getInstance();
        Menu menu1 = entityManager.find(Menu.class, menuCode);
        Menu menu2 = entityManager.find(Menu.class, menuCode);
        // then
        assertEquals(menu1, menu2);
        System.out.println("@@@@@@@@@@@@@menu1 = " + menu1.hashCode());
        System.out.println("@@@@@@@@@@@@@menu2 = " + menu2.hashCode());
    }

    @DisplayName("준영속화 detach 테스트")
    @ParameterizedTest
    @CsvSource({"11, 1000", "12, 1000"})
    void testDetach(int menuCode, int menuPrice) {
        //given
        EntityManager entityManager = EntityManagerGenerator.getInstance();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        // when
        entityTransaction.begin();
        Menu foundMenu = entityManager.find(Menu.class, menuCode);
        /* detach: 특정 엔티티만 준영속 상태(영속성 컨텍스트가 관리하던 객체를 관리하지 않는 상태)로 만든다. */
        entityManager.detach(foundMenu);
        foundMenu.setMenuPrice(menuPrice);
        /* flush: 영속성 컨텍스트의 상태를 DB로 내보낸다.
         * commit하지 않은 상태이므로 rollback 가능 */
        entityManager.flush();
        // then
        assertNotEquals(menuPrice, entityManager.find(Menu.class, menuCode).getMenuPrice());
        entityTransaction.rollback();
    }

    @DisplayName("준영속화 detach 후 다시 영속화 테스트")
    @ParameterizedTest
    @CsvSource({"11, 1000", "12, 1000"})
    void testDetachAndMerge(int menuCode, int menuPrice) {
        //given
        EntityManager entityManager = EntityManagerGenerator.getInstance();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        // when
        entityTransaction.begin();
        Menu foundMenu = entityManager.find(Menu.class, menuCode);
        entityManager.detach(foundMenu);
        foundMenu.setMenuPrice(menuPrice);
        /*  merge: 파라미터로 넘어온 준영속 엔티티 객체의 식별자 값으로 1차 캐시에서 엔티티 객체를 조회
         *   (없으면 DB에서 조회하여 1차 캐시에 저장)
         *   조회한 영속 엔티티 객체에 준영속 상태의 엔티티 객체의 값을 병합 한 뒤 영속 엔티티 객체를 반환
         *   혹은 조회 할 수 없는 데이터라면 새로 생성해서 병합한다. */
        entityManager.merge(foundMenu);
        entityManager.flush();
        // then
        assertEquals(menuPrice, entityManager.find(Menu.class, menuCode).getMenuPrice());
        entityTransaction.rollback();
    }

    @DisplayName("detach 후 merge한 데이터 update 테스트")
    @ParameterizedTest
    @CsvSource({"11, 하양 민트초코죽", "12, 까만 딸기탕후루"})
    void testMergeUpdate(int menuCode, String menuName) {
        // given
        EntityManager entityManager = EntityManagerGenerator.getInstance();
        Menu foundMenu = entityManager.find(Menu.class, menuCode);
        entityManager.detach(foundMenu);
        // when
        foundMenu.setMenuName(menuName);
        Menu refoundMenu = entityManager.find(Menu.class, menuCode);
        entityManager.merge(foundMenu);
        // then
        /* merge 전 refoundMenu의 이름은 DB에 저장 된 기존 이름이지만
         *  이후 foundMenu를 merge하게 된다면 foundMenu의 이름으로 덮어 씌어진다. */
        assertEquals(menuName, refoundMenu.getMenuName());
        System.out.println("@@@@@@@@@@@menuName = " + menuName);
        System.out.println("@@@@@@@@@@@@@@@@@@@refoundMenu = " + refoundMenu.getMenuName());
    }

    @DisplayName("detach 후 merge한 데이터 save 테스트")
    @Test
    void testMergeSave() {
        // given
        EntityManager entityManager = EntityManagerGenerator.getInstance();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        Menu foundMenu = entityManager.find(Menu.class, 21);
        entityManager.detach(foundMenu);
        // when
        entityTransaction.begin();
        foundMenu.setMenuName("치약맛 초코 아이스크림");
        /* 존재하지 않는 코드 값으로 변경
         * 999 코드는 없기 때문에 merge 할 경우 새로운 코드 999번으로 insert 된다. */
        foundMenu.setMenuCode(999);
        entityManager.merge(foundMenu);
        entityTransaction.commit();
        // then
        assertEquals("치약맛 초코 아이스크림", entityManager.find(Menu.class, 999).getMenuName());
    }

    @DisplayName("준영속화 clear 테스트")
    @ParameterizedTest
    @ValueSource(ints = {2, 3})
    void testClearPersistenceContext(int menuCode) {
        // given
        EntityManager entityManager = EntityManagerGenerator.getInstance();
        Menu foundMenu = entityManager.find(Menu.class, menuCode);
        // when
        /* clear: 영속성 컨텍스트를 초기화 한다. -> 영속성 컨텍스트 내의 모든 엔티티를 준영속화 시킴 */
        entityManager.clear();
        // then
        Menu expectedMenu = entityManager.find(Menu.class, menuCode);
        assertNotEquals(foundMenu, expectedMenu);
        System.out.println("foundMenu = " + foundMenu.hashCode());
        System.out.println("expectedMenu = " + expectedMenu.hashCode());
    }

    @DisplayName("준영속화 close 테스트")
    @ParameterizedTest
    @ValueSource(ints = {2, 3})
    void testClosePersistenceContext(int menuCode) {
        // given
        EntityManager entityManager = EntityManagerGenerator.getInstance();
        Menu foundMenu = entityManager.find(Menu.class, menuCode);
        // when
        /* close: 영속성 켄텍스트를 종료한다. */
        entityManager.close();

        // then
        /* assertThrows(예외처리): 예상 오류는 IllegalStateException이다. */
        assertThrows(IllegalStateException.class,
                () -> entityManager.find(Menu.class, menuCode));
    }

    @DisplayName("엔티티 영속성 삭제 remove 테스트")
    @ParameterizedTest
    @ValueSource(ints = {2})
    void testRemoveEntity(int menuCode) {
        // given
        EntityManager entityManager = EntityManagerGenerator.getInstance();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        Menu foundMenu = entityManager.find(Menu.class, menuCode);
        // when
        entityTransaction.begin();
        /* remove: 엔티티를 영속성 컨텍스트 및 데이터베이스에서 삭제
        * 단, 트랜잭션을 제어하지 않으면 데이터 베이스에서 영구 반영 되지는 않는다.
        * 트랜잭션을 커밋하는 순간 영속성 컨텍스트에서 관리하는 엔티티 객체가 데이터베이스에 반영 된다. */
        entityManager.remove(foundMenu);
        /* flush: 영속성 컨텍스트의 변경 내용을 데이터베이스에 동기화 하는 작업 */
        entityManager.flush();
        // then
        /* assertThrows(예외처리): 예상 오류는 IllegalStateException이다. */
        Menu refoundMenu = entityManager.find(Menu.class, menuCode);
        assertNull(refoundMenu);
        System.out.println("@@@@@@refoundMenu = " + refoundMenu);
        entityTransaction.rollback();
    }
}
