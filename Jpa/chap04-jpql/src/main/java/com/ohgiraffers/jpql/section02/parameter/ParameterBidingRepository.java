package com.ohgiraffers.jpql.section02.parameter;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ParameterBidingRepository {

    @PersistenceContext
    private EntityManager entityManager;

    /* 전달 된 파라미터를 JPQL에 대입
    * setParameter: 첫 번째 문자는 jqpl의 menuName, 두 번째 = 파라미터 명 */
    public List<Menu> selectMenuByBidingName(String menuName) {
        String jpql = "SELECT m FROM Section02Menu m WHERE m.menuName = :menuName";
        List<Menu> resultMenuList = entityManager.createQuery(jpql, Menu.class)
                .setParameter("menuName", menuName)
                .getResultList();
        return resultMenuList;
    }

    public List<Menu> selectMenuByBidingPosition(String menuName) {
        String jpql = "SELECT m FROM Section02Menu m WHERE m.menuName = ?1";
        List<Menu> resultMenuList = entityManager.createQuery(jpql, Menu.class)
                .setParameter(1, menuName)
                .getResultList();
        return resultMenuList;
    }
}
