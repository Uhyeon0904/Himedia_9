package com.ohgiraffers.lms_jpa_test.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tbl_category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryCode;
    private String categoryName;
    @OneToMany(mappedBy = "category")
    private List<Drink> drinkList;
}
