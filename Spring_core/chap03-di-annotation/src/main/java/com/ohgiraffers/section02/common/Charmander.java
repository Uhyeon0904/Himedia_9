package com.ohgiraffers.section02.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
/* 여러 bean을 찾게 되는 경우 @primary 어노테이션을 적용한 bean을 우선시 적용한다. */
/* @primary 어노테이션을 설정하면 @AutoWired로 동일한 타입의 여러 bean을 찾게 되는 경우 자동으로
* 연결 우선 시 할 타입으로 설정 된다.
* 동일한 타입의 클래스 중 한 개만 @Primary 어노테이션을 사용할 수 있다. */
public class Charmander implements Pokemon{
    @Override
    public void attack() {
        System.out.println("파이리 불꽃 공격🔥");
    }
}
