package com.ohgiraffers.jwtsecurity.common.utils;


import com.ohgiraffers.jwtsecurity.user.entity.User;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
    public static String generateJwtToken(User user) {
        /* 토큰 만료시간 */
        Date expireTime = new Date(System.currentTimeMillis() + tokenValidateTime);

        JwtBuilder builder = Jwts.builder()
                /* 헤더 */
                .setHeader(createHeader())
                /* 페이로드 */
                .setClaims(createClaims(user))
                .setSubject("ohgiraffers token" + user.getUserNo())
                /* 시그너처
                * SignatureAlgorithm.HS256: 시그니처 암호화 알고리즘 */
                .signWith(SignatureAlgorithm.HS256, createSignature())
                .setExpiration(expireTime);

        /* compact: 문자열로 변환 */
        return builder.compact();
    }

    /**
     * description. 토큰의 header를 설정하는 메소드
     *
     * @return Map<String, Object> (header의 설정 정보)
     */
    private static Map<String, Object> createHeader() {
        Map<String, Object> header = new HashMap<>();

        /* 타입이 json web token */
        header.put("type", "jwt");
        /* 알고리즘으로 암호화 방식 설정 */
        header.put("alg", "HS256");
        /* 만들어진 시간 정보 */
        header.put("date", System.currentTimeMillis());

        return header;
    }


    /**
     * description. 사용자 정보를 기반으로 claim을 생성하는 메소드
     *
     * @param user (사용자 정보)
     * @return Map<String, Object> (claims 정보)
     */
    private static Map<String, Object> createClaims(User user) {
        Map<String, Object> claims = new HashMap<>();

        claims.put("username", user.getUserName());
        claims.put("Role", user.getRole());

        return claims;
    }


    /**
     * description. JWT 서명(시그니처)을 발급하는 메소드
     *
     * @return Key : SecretKeySpec
     */
    /* 시큐리티가 갖고 있는 Key를 반환해 준다. */
    private static Key createSignature() {
        byte[] secretBytes = DatatypeConverter.parseBase64Binary(jwtSecretKey);

        return new SecretKeySpec(secretBytes, SignatureAlgorithm.HS256.getJcaName());
    }

}
