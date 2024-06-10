package com.ohgiraffers.jwtsecurity.common.utils;


import org.springframework.stereotype.Component;

/*
 * 토큰을 관리하기 위한 utils 모음 클래스
 * */
@Component
public class TokenUtils {



    /**
     * description. header의 token을 분리하는 메소드
     *
     * @param header (Authrization의 header값)
     * @return String (Authrization의 token 부분)
     */


    /**
     * description. 토큰이 유효한지 확인하는 메소드
     *
     * @param token
     * @return boolean : 유효 판단 여부
     */


    /**
     * description. 토큰을 복호화 하는 메소드
     *
     * @param token
     * @return Claims
     */

    /**
     * description. 토큰을 생성하는 메소드
     *
     * @param user
     * @return token (String)
     */

    /**
     * description. 토큰의 header를 설정하는 메소드
     *
     * @return Map<String, Object> (header의 설정 정보)
     */


    /**
     * description. 사용자 정보를 기반으로 claim을 생성하는 메소드
     *
     * @param user (사용자 정보)
     * @return Map<String, Object> (claims 정보)
     */


    /**
     * description. JWT 서명을 발급하는 메소드
     *
     * @return Key : SecretKeySpec
     */

}
