package com.ohgiraffers.jpql.section06.join;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JoinRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Menu> selectByInnerJoin() {
        String jpql =
                "SELECT m " +
                "FROM Section06Menu m " +
                "JOIN m.category c";
        List<Menu> menuList = entityManager.createQuery(jpql, Menu.class).getResultList();
        return menuList;
    }
    public List<Object[]> selectByOuterJoin() {
        String jpql =
                "SELECT m.menuName, c.categoryName " +
                "FROM Section06Menu m " +
                "RIGHT JOIN m.category c " +
                /* c.categoryCode 가능, 아래와 같은 방법은 그렇게 참조해서 사용 가능하다는 것 */
                "ORDER BY m.category.categoryCode";
        List<Object[]> menuList = entityManager.createQuery(jpql).getResultList();
        return menuList;
    }

    public List<Object[]> selectByCollectionJoin() {
        String jpql =
                "SELECT m.menuName, c.categoryName " +
                "FROM Section06Category c " +
                "LEFT JOIN c.menuList m ";
        List<Object[]> categoryList = entityManager.createQuery(jpql).getResultList();
        return categoryList;
    }

    /* 크로스 조인 현상 모든 값들이 한 번씩 매핑되서 출력 */
    public List<Object[]> selectByThetaJoin() {
        String jpql =
                "SELECT m.menuName, c.categoryName " +
                "FROM Section06Category c, Section06Menu m ";
        List<Object[]> categoryList = entityManager.createQuery(jpql).getResultList();
        return categoryList;
    }

    public List<Menu> selectByFetchJoin() {
        String jpql =
                "SELECT m " +
                        "FROM Section06Menu m " +
                        /* 즉시 로딩을 수행해서 가져온다. */
                        "JOIN FETCH m.category c";
        List<Menu> menuList = entityManager.createQuery(jpql, Menu.class).getResultList();
        return menuList;
    }
}
