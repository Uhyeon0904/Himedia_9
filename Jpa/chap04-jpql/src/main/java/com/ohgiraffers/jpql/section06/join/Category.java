package com.ohgiraffers.jpql.section06.join;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity(name = "Section06Category")
@Table(name = "tbl_category")
public class Category {

    @Id
    private int categoryCode;

    private String categoryName;

    private String refCategoryCode;

    /* 진짜 연관 관계를 맺고 있는 필드의 필드명 */
    @OneToMany(mappedBy = "category")
    private List<Menu> menuList;

    public Category() {}
}
