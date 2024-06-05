package com.ohgiraffers.associationmapping.section03.bidirection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class BiDirectionRepository {

    @PersistenceContext
    private EntityManager entityManager;

    /* 메뉴 코드 찾기
    * 서비스에서 넘어온 파라미터로 메뉴 코드 찾기 */
    public Menu findMenu(int menuCode) {
        return entityManager.find(Menu.class, menuCode);
    }

    /* 카테고리 코드 찾기
    * 서비스에서 넘어온 파라미터로 카테고리 코드 찾기 */
    public Category findCategory(int categoryCode) {
        return entityManager.find(Category.class, categoryCode);
    }
}
