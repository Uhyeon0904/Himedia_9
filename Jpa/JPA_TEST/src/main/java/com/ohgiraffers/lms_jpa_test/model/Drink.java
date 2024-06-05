package com.ohgiraffers.lms_jpa_test.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_drink")
public class Drink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int drinkCode;
    private String drinkName;
    private int drinkPrice;
    @ManyToOne
    @JoinColumn(name = "categoryCode")
    private Category category;

    public void modifyDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }
}
