package com.ohgiraffers.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/* 어떤 URL에다가 Interceptor를 실행 할 건지 설정 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    private final StopWatchInterceptor stopWatchInterceptor;

    /* 생성자 의존성 주입 */
    public WebConfiguration(StopWatchInterceptor stopWatchInterceptor) {
        this.stopWatchInterceptor = stopWatchInterceptor;
    }

    /* addInterceptors: WebMvcConfigurer 인터페이스의 메소드 */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(stopWatchInterceptor)
                .addPathPatterns("/stopwatch");
    }
}
