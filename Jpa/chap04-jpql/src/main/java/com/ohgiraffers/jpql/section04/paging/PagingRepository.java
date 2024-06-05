package com.ohgiraffers.jpql.section04.paging;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PagingRepository {

    @PersistenceContext
    private EntityManager entityManager;

    /* 여러 행의 페이징 기능 */
    public List<Menu> usingPagingAPI(int offset, int limit) {
        String jpql = "SELECT m FROM Section04Menu m ORDER BY m.menuCode DESC";
        List<Menu> pagingMenuList = entityManager.createQuery(jpql, Menu.class)
                /* 조회를 어디서부터 시작 할 것인가? */
                .setFirstResult(offset)
                /* 조히하고자 하는 개수를 의미 */
                .setMaxResults(limit)
                .getResultList();
                return pagingMenuList;
    }
}
