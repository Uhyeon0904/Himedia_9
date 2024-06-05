package com.ohgiraffers.associationmapping.section01.manytoone;

import jakarta.persistence.*;

@Entity(name = "menu_and_category")
@Table(name = "tbl_menu")
public class Menu {

    @Id
    private int menuCode;
    private String menuName;
    private int menuPrice;

    /* Menu Entity 기준으로 Category 테이블과 관계는 N:1
     * @JoinColumn(name = "categoryCode"): Category 클래스에서 어떤 필드(테이블)와 Join을 할 것인가
     * cascade(영속성 전이): 특정 엔티티를 영속화 할 때 연관 된 엔티티도 함께 영속화 한다는 의미이다.
     * 메뉴 엔티티가 저장이 되면 카테고리 엔티티도 같이 저장이 된다. */
    /* ManyToOne 관계에서는 로딩이 즉시(EAGER) 로딩이 디폴트 값이다.
    * 카테고리 엔티티가 메뉴 엔티티를 참조하고 있다. */
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name ="categoryCode")
    private Category category;

    private String orderableStatus;

    protected Menu() {}

    public Menu(int menuCode, String menuName, int menuPrice, Category category, String orderableStatus) {
        this.menuCode = menuCode;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.category = category;
        this.orderableStatus = orderableStatus;
    }

    public int getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(int menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(int menuPrice) {
        this.menuPrice = menuPrice;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getOrderableStatus() {
        return orderableStatus;
    }

    public void setOrderableStatus(String orderableStatus) {
        this.orderableStatus = orderableStatus;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuCode=" + menuCode +
                ", menuName='" + menuName + '\'' +
                ", menuPrice=" + menuPrice +
                ", category=" + category +
                ", orderableStatus='" + orderableStatus + '\'' +
                '}';
    }
}
