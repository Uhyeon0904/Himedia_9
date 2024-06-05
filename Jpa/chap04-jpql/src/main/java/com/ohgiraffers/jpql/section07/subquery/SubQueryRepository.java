package com.ohgiraffers.jpql.section07.subquery;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SubQueryRepository {

    /* JPA에서는 FROM 절에만 서브쿼리를 사용할 수 있는 게 표준이다.
    * 특정 구현체를 사용해서 SELECT 절에도 사용은 가능하다. */

    @PersistenceContext
    private EntityManager entityManager;

    public List<Menu> selectWithSubQuery(String categoryName) {
        String jpql =
                "SELECT m " +
                "FROM Section07Menu m " +
                "WHERE m.categoryCode = " +
                        "(SELECT c.categoryCode " +
                        "FROM Section07Category c " +
                        "WHERE c.categoryName = :categoryName)";
        List<Menu> menuList = entityManager.createQuery(jpql, Menu.class)
                .setParameter("categoryName", categoryName)
                .getResultList();
        return menuList;
    }
}
