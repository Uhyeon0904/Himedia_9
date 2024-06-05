package com.ohgiraffers.associationmapping.section02.onetomany;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity(name = "category_and_menu")
@Table(name = "tbl_category")
public class Category {

    @Id
    private int categoryCode;
    private String categoryName;
    private Integer refCategoryCode;

    /* 즉시 로딩 or 지연 로딩
    * 기본적으로는 지연 로딩이지만 필요에 따라 즉시 로딩으로 변경할 수 있다. */
    /* OneToMany 관계에서는 로딩이 지연(LAZY) 로딩이 디폴트 값이다.*/
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    /* FK 컬럼을 사용, 카테고리 클래스의 categoryCode 필드가 아닌 Menu 클래스의 categoryCode 필드명 작성 */
    @JoinColumn(name = "categoryCode")
    private List<Menu> menuList;

    protected Category() {
    }

    public Category(
            int categoryCode, String categoryName,
            Integer refCategoryCode, List<Menu> menuList
    ) {
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
        this.refCategoryCode = refCategoryCode;
        this.menuList = menuList;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getRefCategoryCode() {
        return refCategoryCode;
    }

    public void setRefCategoryCode(Integer refCategoryCode) {
        this.refCategoryCode = refCategoryCode;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryCode=" + categoryCode +
                ", categoryName='" + categoryName + '\'' +
                ", refCategoryCode=" + refCategoryCode +
                ", menuList=" + menuList +
                '}';
    }
}
