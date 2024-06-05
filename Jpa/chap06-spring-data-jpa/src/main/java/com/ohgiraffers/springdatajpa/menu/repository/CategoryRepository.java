package com.ohgiraffers.springdatajpa.menu.repository;

import com.ohgiraffers.springdatajpa.menu.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    /* 카테고리 전체를 카테고리 코드 기준으로 내림차순 조회 하겠다.
    * findAll 메소드로 조회 가능하지만 JPQL 설정 테스트를 위해 작성함 */
//    @Query("SELECT c FROM Category c ORDER BY c.categoryCode DESC")
    /* nativeQuery = true: 디폴트는 false 이기 때문에 true 변경해 줘야 인식한다. */
    @Query(value = "SELECT category_code, category_name, ref_category_code " +
            "FROM tbl_category ORDER BY category_code DESC ",
            nativeQuery = true)
    List<Category> findAllCategory();
}
