package com.ohgiraffers.jwtsecurity.auth.handler;

import com.ohgiraffers.jwtsecurity.auth.model.DetailsUser;
import com.ohgiraffers.jwtsecurity.auth.model.service.DetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/* AuthenticationProvider: 비밀번호를 매칭? */
public class CustomAuthenticationProvider  implements AuthenticationProvider {
    /* 강제 오버라이딩 */

    @Autowired
    private DetailsService detailsService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        UsernamePasswordAuthenticationToken loginToken = (UsernamePasswordAuthenticationToken) authentication;

        /* 토큰에서 id를 꺼내기 */
        String id = loginToken.getName();

        /* getCredentials 오브젝트 타입으로 반환 하기때문에 String으로 다운 캐스팅*/
        String pass = (String) loginToken.getCredentials();

        /* loadUserByUsername: id를 주고 그 결과를 부모 타입으로 반환하기 때문에 다운 캐스팅*/
        DetailsUser detailsUser =(DetailsUser) detailsService.loadUserByUsername(id);

        /* pass와 getPassword 매치 시 맞다면 인증된 정보를 반환 */
        if (!passwordEncoder.matches(pass, detailsUser.getPassword())) {
            throw new BadCredentialsException(pass + "는 틀린 비밀번호 입니다.");
        }
        return new UsernamePasswordAuthenticationToken(detailsUser, pass, detailsUser.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
