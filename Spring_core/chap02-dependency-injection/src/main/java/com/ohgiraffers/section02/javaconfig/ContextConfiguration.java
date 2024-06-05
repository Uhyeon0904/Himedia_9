package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.Account;
import com.ohgiraffers.common.MemberDTO;
import com.ohgiraffers.common.PersonalAccount;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextConfiguration {

    /* bean 설정을 해주려면 @Bean 어노테이션을 달아줘야 한다. */
    @Bean
    public Account accountGenerator() {
        /* bean 설정*/
        return new PersonalAccount(20, "110-234-567890");
    }

    @Bean
    public MemberDTO memberGenerator() {
        // 생성자 주입
        /* MemberDTO 생성자를 통해 Account를 생성하는 메소드를 호출한 리턴 값을
        전달하여 bean을 조립할 수 있다.*/
        return new MemberDTO(1, "판다", "panda@gmail.com", accountGenerator());

        /* setter 주입
        *   setter를 통해 Account를 생성하는 메소드를 호출한 리턴값을 전달하여 bean 조립 */
//        MemberDTO member = new MemberDTO();
//        member.setSequence(1);
//        member.setName("판다");
//        member.setEmail("panda@gmail.com");
//        member.setPersonalAccount(accountGenerator());
//
//        return member;
    }
}
