package com.ohgiraffers.section02.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EntityManagerCRUD {

    private EntityManager entityManager;

    /* 1. 특정 메뉴 코드로 메뉴 조회하는 기능 */
    public Menu findMenuByMenuCode(int menuCode) {
        entityManager = EntityManagerGenerator.getInstance();
        /* find: 기본키(PK)를 사용하여 메뉴클래스에서 해당 코드를 찾는다. */
        return entityManager.find(Menu.class, menuCode);
    }

    /* 2. 새로운 메뉴 저장하는 기능 */
    public Long saveAndReturnAllCount(Menu newMenu) {
        entityManager = EntityManagerGenerator.getInstance();
        /* 엔티티 메니저에서 트랜잭션 객체 생성 */
        EntityTransaction entityTransaction = entityManager.getTransaction();
        /* 트랜잭션 시작 요청 */
        entityTransaction.begin();
        /* persist: 저장하다? 라는 의미(영속성 컨텍스트에 엔티티를 저장하는 역할) */
        entityManager.persist(newMenu);
        /* 메소드 실행 후 저장 요청 */
        entityTransaction.commit();
        return getCount(entityManager);
    }

    /* 3. 메뉴 개수 조회하는 기능 */
    private Long getCount(EntityManager entityManager) {
        /* JPQL 문법 -> 나중에 별도 챕터에서 다룸 */
        return entityManager.createQuery
                ("SELECT COUNT(*) FROM Section02Menu", Long.class).getSingleResult();
    }

    /* 4. 메뉴 이름 수정하는 기능 */
    public Menu modifyMenuName(int menuCode, String menuName) {
        entityManager = EntityManagerGenerator.getInstance();
        Menu foundMenu = entityManager.find(Menu.class, menuCode);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        foundMenu.setMenuName(menuName);
        transaction.commit();
        return foundMenu;
    }

    /* 5. 특정 메뉴 코드로 메뉴 삭제하는 기능 */
    public Long removeAndReturnAllCount(int menuCode) {
        entityManager = EntityManagerGenerator.getInstance();
        Menu foundMenu = entityManager.find(Menu.class, menuCode);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        /* remove: 삭제 기능(삭제하고자 하는 엔티티를 파라미터로 전달) */
        entityManager.remove(foundMenu);
        transaction.commit();
        return getCount(entityManager);
    }
}
