package com.ohgiraffers.springdatajpa.menu.repository;

import com.ohgiraffers.springdatajpa.menu.entity.Menu;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/* 인터페이스에 JpaRepository를 상속 받는다.
* JpaRepository<엔티티, Id타입>
* 따로 해줄 것은 없고 JpaRepository를 상속 받기만 하면 된다. */
public interface MenuRepository extends JpaRepository<Menu, Integer> {

    /* findByMenuPriceGreaterThan: find 다음 Menu 엔티티 명이 들어가야하지만 JpaRepository 에서
    * 제네릭 타입으로 Menu를 지정해 줬기 때문에 생략 가능
    * By 뒤 MenuPrice는 변수 이름
    * GreaterThan: 초과하다 라는 의미, 왼쪽 피연산자가 오른쪽 피연산자 보다 큰지 '>' 사용 */
    /* ★ 파라미터로 전달 받은 가격을 초과하는 메뉴 목록 조회 ★ */
    List<Menu> findByMenuPriceGreaterThan(Integer menuPrice);
    /* ★ 파라미터로 전달 받은 가격을 초과하는 메뉴 목록 가격순으로 조회 ★ */
    List<Menu> findByMenuPriceGreaterThanOrderByMenuPriceDesc(Integer menuPrice);
    /* ★ 파라미터로 전달 받은 가격을 초과하는 메뉴 목록 전달 받은 정렬 기준으로 조회 ★ */
    List<Menu> findByMenuPriceGreaterThan(Integer menuPrice, Sort sort);
}
