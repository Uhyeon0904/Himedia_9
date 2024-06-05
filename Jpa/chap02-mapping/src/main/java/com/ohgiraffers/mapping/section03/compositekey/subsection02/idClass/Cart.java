package com.ohgiraffers.mapping.section03.compositekey.subsection02.idClass;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_cart")
/* id를 해당 클래스의 형태로 사용하겠다. */
@IdClass(CartCompositeKey.class)
public class Cart {

    @Id
    @Column(name = "cart_owner")
    private int cartOwner;

    @Id
    @Column(name = "added_book")
    private int addedBook;

    @Column(name = "quantity")
    private int quantity;

    protected Cart() {
    }

    public Cart(int cartOwner, int addedBook, int quantity) {
        this.cartOwner = cartOwner;
        this.addedBook = addedBook;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartOwner=" + cartOwner +
                ", addedBook=" + addedBook +
                ", quantity=" + quantity +
                '}';
    }
}
