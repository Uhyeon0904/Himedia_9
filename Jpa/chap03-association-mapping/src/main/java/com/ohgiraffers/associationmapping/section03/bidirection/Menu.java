package com.ohgiraffers.associationmapping.section03.bidirection;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity(name = "bidirection_menu")
@Table(name = "tbl_menu")
public class Menu {

    @Id
    private int menuCode;

    private String menuName;

    private int menuPrice;

    /* 즉시 로딩 */
    @ManyToOne
    @JoinColumn(name = "categoryCode")
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
}
