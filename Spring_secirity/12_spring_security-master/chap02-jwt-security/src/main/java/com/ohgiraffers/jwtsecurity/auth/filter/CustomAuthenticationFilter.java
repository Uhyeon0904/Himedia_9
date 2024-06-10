package com.ohgiraffers.jwtsecurity.auth.filter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ohgiraffers.jwtsecurity.auth.model.dto.LoginDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;

public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter  {

    public CustomAuthenticationFilter(AuthenticationManager authenticationManager) {
        super.setAuthenticationManager(authenticationManager);
    }


/**
     * description. 지정된 url 요청 시 해당 요청을 가로채서 검증 로직을 수행하는 메소드
     *
     * @param request  : HttpServletRequest
     * @param response : HttpServletResponse
     * @return Authentication
     * @throws AuthenticationException
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        /* 토큰 생성 */
        UsernamePasswordAuthenticationToken authRequest;

        try {
            authRequest = getAuthRequest(request);
            setDetails(request, authRequest);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return this.getAuthenticationManager().authenticate(authRequest);
    }


    /**
     * description. 사용자의 로그인 요청 시 요청 정보를 임시 토큰에 저장하는 메소드
     *
     * @param request : HttpServletRequest
     * @return UsernamePasswordAuthenticationToken
     * @throws IOException
     */
    /* 임시 토큰 생성
    * HttpServletRequest request로 파라미터를 받는다. */
    private UsernamePasswordAuthenticationToken getAuthRequest(HttpServletRequest request) throws IOException {

        /* ObjectMapper: JSON 타입으로 변환 */
        ObjectMapper objectMapper = new ObjectMapper();

        /* json 파싱하는 구문, 만약 판별하기 어렵다면 자동으로 ??? */
        objectMapper.configure(JsonParser.Feature.AUTO_CLOSE_SOURCE, true);

        /* InputStream으로 읽어서 LoginDTO 타입으로 변환
        * getInputStream: 예외처리 필요 */
        LoginDTO user = objectMapper.readValue(request.getInputStream(), LoginDTO.class);
        return new UsernamePasswordAuthenticationToken(user.getId(), user.getPass());
    }

}
