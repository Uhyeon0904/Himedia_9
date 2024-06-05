package com.ohgiraffers.section01.xmlconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {

    public static void main(String[] args) {

        // XML configuration을 이용한 방법

        /* ApplicationContext는 인터페이스 이므로 클래스를 이용해 생성해야 된다.*/
        ApplicationContext context = new GenericXmlApplicationContext
                ("section01/xmlconfig/spring-context.xml"/* xml 파일 경로*/);

        /* bean의 id를 이용해서 bean을 가져오는 방법 */
    // MemberDTO member = (MemberDTO) context.getBean("member");

        /* bean의 클래스 메타 정보를 전달하여 가져오는 방법 */
    // MemberDTO member = context.getBean(MemberDTO.class);

        /* bean의 id와 클래스의 메타 정보를 둘 다 가져오는 방법; 가장 정확함*/
        MemberDTO member = context.getBean("member", MemberDTO.class);

        System.out.println("member = " + member);
        // member = MemberDTO{sequence=1, id='user01', pwd='pass01', name='판다'}
    }
}
