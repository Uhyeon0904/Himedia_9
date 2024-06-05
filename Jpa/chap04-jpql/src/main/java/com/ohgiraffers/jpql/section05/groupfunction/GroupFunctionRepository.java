package com.ohgiraffers.jpql.section05.groupfunction;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GroupFunctionRepository {

    @PersistenceContext
    private EntityManager entityManager;

    /* COUNT를 이용한 JPQL */
    public Long countMenuOfCategory(int categoryCode) {
        String jpql =
                "SELECT COUNT(m.menuCode) " +
                "FROM Section05Menu m " +
                "WHERE m.categoryCode = :categoryCode";
        Long countOfMenu = entityManager.createQuery(jpql, Long.class)
                .setParameter("categoryCode", categoryCode)
                .getSingleResult();
        return countOfMenu;
    }

    public Long otherWithNoResult(int categoryCode) {
        String jpql = "SELECT SUM(m.menuPrice) FROM Section05Menu m " +
                "WHERE m.categoryCode = :categoryCode";
        /* COUNT 외의 다른 그룹함수는 결과 값이 없을 경우 NULL이 반환 되기 때문에 기본 자료형으로 다룰 수 없다.
        * Long과 값이 Wrapper 클래스 자료형으로 다루어주어야 한다. */
        Long sumOfMenu = entityManager.createQuery(jpql, Long.class)
                .setParameter("categoryCode", categoryCode)
                .getSingleResult();
        return sumOfMenu;
    }

    public List<Object[]> selectByGroupByHaving(Long minPrice) {
        String jpql = "SELECT m.categoryCode, SUM(m.menuPrice) " +
                "FROM Section05Menu m " +
                "GROUP BY m.categoryCode HAVING SUM(m.menuPrice) >= :minPrice";
        List<Object[]> sumPriceOfCategoryList = entityManager.createQuery(jpql)
                .setParameter("minPrice", minPrice)
                .getResultList();

        return sumPriceOfCategoryList;
    }
}
