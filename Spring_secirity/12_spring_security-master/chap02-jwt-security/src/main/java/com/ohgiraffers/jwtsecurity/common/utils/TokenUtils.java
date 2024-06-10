package com.ohgiraffers.jwtsecurity.common.utils;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.xml.bind.DatatypeConverter;

/*
 * 토큰을 관리하기 위한 utils 모음 클래스
 * */
@Component
public class TokenUtils {

    private static String jwtSecretKey;

    private static Long tokenValidateTime;

    @Value("${jwt.key}")
    public void setJwtSecretKey(String jwtSecretKey) {
        TokenUtils.jwtSecretKey = jwtSecretKey;
    }

    @Value("${jwt.time}")
    public void setTokenValidateTime(Long tokenValidateTime) {
        TokenUtils.tokenValidateTime = tokenValidateTime;
    }



    /**
     * description. header의 token을 분리하는 메소드
     *
     * @param header (Authorization의 header값)
     * @return String (Authorization의 token 부분)
     */
    public static String splitHeader(String header) {
        /* 헤더가 빈 값이 아니라면 */
        if (!header.equals("")) {
            /* 공백 부분을 분리 후 첫 번째 값을 가져온다. */
            return header.split(" ")[1];
        } else {
            /* 빈 값인 경우 null 리턴 */
            return null;
        }
    }


    /**
     * description. 토큰이 유효한지 확인하는 메소드
     *
     * @param token
     * @return boolean : 유효 판단 여부
     */
    /* 정적 메소드로 받아서 논리 값으로 반환을 받는다. */
    public static boolean isValidToken(String token) {
        /* 토큰이 유효한지 확인하려면 복호화를 해야한다.
        * 복호화를 시켜야지 토큰이 살아있다는 것 */

        try {
            Claims claims = getClaimsFromToken(token);
            return true;
        } catch (ExpiredJwtException e) {
            /* 토큰이 만료 됐을 때 */
            e.printStackTrace();
            return false;
        } catch (JwtException e) {
            /* 토큰 자체에 에러가 났을 때 */
            e.printStackTrace();
            return false;
        } catch (NullPointerException e) {
            /* 토큰이 비어있을 때*/
            e.printStackTrace();
            return false;
        }
    }


    /**
     * description. 토큰을 복호화 하는 메소드
     *
     * @param token
     * @return Claims
     */
    public static Claims getClaimsFromToken(String token) {
        /* Claims: 토큰에 payload 담긴 데이터를 ???? */
        /* jwt를 파싱해서 복화를해서 가지고 올건데*/
        return Jwts.parser()
                /* setSigningKey: 사인키를 시크릿키(jwtSecretKey) 방식으로 64 바이너리로 파싱한다. */
                .setSigningKey(DatatypeConverter.parseBase64Binary(jwtSecretKey))
                /* parseClaimsJws: 헤더, 페이로드, 시그니처로 파싱 후 */
                .parseClaimsJws(token)
                /* getBody: 페이로드에 해당하는 데이터를 가져온다. */
                .getBody();
    }

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
