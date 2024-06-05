package com.ohgiraffers.jpql.section01.simple;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.util.List;

@Repository
public class SimpleJPQLRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public String selectSingleMenuByTypedQuery() {
        /* FROM 절에는 반드시 별칭이 필요하며 as는 생략이 가능 */
        String jpql = "SELECT m.menuName FROM Section01Menu as m WHERE m.menuCode = 8";
        /* createQuery를 호출 했을 때 반환 값은 TypedQuery이다. */
        TypedQuery<String> query = entityManager.createQuery(jpql, String.class);
        String resultMenuName = query.getSingleResult();
        return resultMenuName;
    }

    /* 어떤 타입이 올지 모를 땐 Object 타입으로 Query 타입을 반환 받는다. */
    public Object selectSingleMenuByQuery() {
        String jpql = "SELECT m.menuName FROM Section01Menu as m WHERE m.menuCode = 8";
        /* 반환되는 타입을 지정해 주지 않으면 Query 타입으로 반환 된다. */
        Query query = entityManager.createQuery(jpql);
        Object resultMenuName = query.getSingleResult();
        return resultMenuName;
    }

    /* Menu 타입으로 받고, 하나의 단일 행을 가져온다. */
    public Menu selectSingleRowByTypedQuery() {
        String jpql = "SELECT m FROM Section01Menu m WHERE m.menuCode = 8";
        TypedQuery<Menu> query = entityManager.createQuery(jpql, Menu.class);
        Menu resultMenu = query.getSingleResult();
        return resultMenu;
    }

    /* Menu List 타입으로 받고, 여러 개의 행을 가져온다. */
    public List<Menu> selectMultiRowByTypedQuery() {
        String jpql = "SELECT m FROM Section01Menu m";
        TypedQuery<Menu> query = entityManager.createQuery(jpql, Menu.class);
        List<Menu> resultList = query.getResultList();
        return resultList;
    }

    /* distinct를 사용한 중복 제거 조회 */
    public List<Integer> selectUsingDistinct() {
        String jpql = "SELECT DISTINCT m.categoryCode FROM Section01Menu m";
        TypedQuery<Integer> query = entityManager.createQuery(jpql, Integer.class);
        List<Integer> resultCategoryList = query.getResultList();
        return resultCategoryList;
    }

    /* 11, 12 카테고리 코드를 가진 메뉴 목록 조회 */
    public List<Menu> testSelectUsingIn() {
        String jpql = "SELECT m.menuName FROM Section01Menu m WHERE m.categoryCode IN (11, 12)";
        TypedQuery<Menu> query = entityManager.createQuery(jpql, Menu.class);
        List<Menu> resultCategoryCode = query.getResultList();
        return resultCategoryCode;
    }

    /* "마늘" 이라는 문자열이 메뉴명에 포함되는 메뉴 목록 조회 */
    public List<Menu> testSelectUsingLike() {
        String jpql = "SELECT m.menuName FROM Section01Menu m WHERE m.menuName LIKE '%마늘%'";
        TypedQuery<Menu> query = entityManager.createQuery(jpql, Menu.class);
        List<Menu> resultMenuName = query.getResultList();
        return resultMenuName;
    }
}
