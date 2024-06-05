package com.ohgiraffers.springdatajpa.menu.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

@Entity
@Table(name = "tbl_menu")
@Getter
/* 기본 생성자를 접근제한을 protected로 설정을 한다.
* 상속한 곳에서만 사용이 가능하도록 정의 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
/* @AllArgsConstructor 순서와 상관없이 값이 들어왔을 때 필드의 순서가 틀리다면 오류가 날 수 있다.
* 예) categoryCode, menuPrice 순서로 값이 입력 될 경우 에러 사항*/
/* @ToString: 사용 가능하나 연관 관계 매핑 필드는 제거하고 사용 */
/* @Setter 지양 -> 객체를 언제든지 변경할 수 있으며, 객체의 안전성 보장을 할 수 없다.
* 값 변경이 필요한 경우에는 해당 기능을 위한 메소드를 별도로 생성 */
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int menuCode;

    private String menuName;

    private int menuPrice;

    private int categoryCode;

    private String orderableStatus;

    public void modifyMenuName(String menuName) {
        this.menuName = menuName;
    }
}


