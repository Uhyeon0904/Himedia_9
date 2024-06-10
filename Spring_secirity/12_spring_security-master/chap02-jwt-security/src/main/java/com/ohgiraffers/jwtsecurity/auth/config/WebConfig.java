package com.ohgiraffers.jwtsecurity.auth.config;

import com.ohgiraffers.jwtsecurity.auth.filter.HeaderFilter;
import com.ohgiraffers.jwtsecurity.auth.interceptor.JwtTokenInterceptor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.header.Header;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
* Web configuration을 위한 클래스
* */
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
            /* 정적 자원을 배열로 만듦 */
            "classpath:/static/", "classpath:/public/", "classpath:/", "classpath:/resources/",
            "classpath:/META-INF/resources/", "classpath:/META-INF/resources/webjars/"
    };

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("**").addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
    }

    @Bean
    public FilterRegistrationBean<HeaderFilter> getFilterRegistrationBean() {
        FilterRegistrationBean<HeaderFilter> registrationBean = new FilterRegistrationBean<HeaderFilter>(createHeaderFilter());
        /* 이 필터의 순서를 가장 처음으로 올려주라는 설정 */
        registrationBean.setOrder(Integer.MIN_VALUE);
        /* 모든 요청에 대해 해당 필터를 거쳐라 */
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }

    @Bean
    public HeaderFilter createHeaderFilter() {
        return new HeaderFilter();
    }

    @Bean
    public JwtTokenInterceptor jwtTokenInterceptor() {
        return new JwtTokenInterceptor();
    }
}
