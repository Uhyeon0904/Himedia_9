package com.ohgiraffers.section02.javacofig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/* @Configuration: 해당 클래스가 bean을 생성하는 클래스임을 표기 */
@Configuration
public class ContextConfiguration {

    /* @Bean("member"): name 생략 가능, 이름을 정해주지 않으면 메소드 이름을 자동으로 지정해 준다.*/
    /* @Bean: 해당 메소드의 반환 값을 spring container에 bean으로 등록한다는 의미 */
    @Bean(name = "member")
    public MemberDTO getMember() {
        return new MemberDTO(2, "user02", "pass02", "다람쥐");
    }
}
