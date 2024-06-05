package com.ohgiraffers.common;

// abstract: 추상클래스

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public abstract class Product {

    private String name;

    private int price;

    @Override
    public String toString() {
        return name + " " + price;
    }
}
