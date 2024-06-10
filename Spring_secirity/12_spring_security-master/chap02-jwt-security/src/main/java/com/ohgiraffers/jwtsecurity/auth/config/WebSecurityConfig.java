package com.ohgiraffers.jwtsecurity.auth.config;

import com.ohgiraffers.jwtsecurity.auth.filter.CustomAuthenticationFilter;
import com.ohgiraffers.jwtsecurity.auth.filter.JwtAuthorizationFilter;
import com.ohgiraffers.jwtsecurity.auth.handler.CustomAuthFailureHandler;
import com.ohgiraffers.jwtsecurity.auth.handler.CustomAuthSuccessHandler;
import com.ohgiraffers.jwtsecurity.auth.handler.CustomAuthenticationProvider;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {

    /**
     * description. 정적 자원에 대한 인증된 사용자의 접근을 설정하는 메소드
     *
     * @return WebSecurityCustomizer
     */


    /**
     * description. Security filter chain 설정 메소드
     *
     * @param http : HttpSecurity
     * @return SecurityFilterChain
     * @throws Exception
     */


    /**
     * description. 사용자 요청(request) 시 수행되는 메소드
     *
     * @return JwtAuthorizationFilter
     */


    /**
     * description. Authentization의 인증 메소드를 제공하는 매니저(= Provider의 인터페이스)를 반환하는 메소드
     *
     * @return AuthenticationManager
     */


    /**
     * description. 사용자의 id와 password를 DB와 비교하여 검증하는 핸들러 메소드
     *
     * @return CustomAuthenticationProvider
     */


    /**
     * description. 비밀번호를 암호화하는 인코더를 반환하는 메소드
     *
     * @return BCryptPasswordEncoder
     */


    /**
     * description. 사용자의 인증 요청을 가로채서 로그인 로직을 수행하는 필터를 반환하는 메소드
     *
     * @return CustomAuthenticationFilter
     */


    /**
     * description. 사용자 정보가 맞을 경우 (= 로그인 성공 시) 수행하는 핸들러를 반환하는 메소드
     *
     * @return CustomAuthSuccessHandler
     */


    /**
     * description. 사용자 정보가 맞지 않는 경우 (= 로그인 실패 시) 수행하는 핸들러를 반환하는 메소드
     *
     * @return CustomAuthFailureHandler
     */

}
