package com.ohgiraffers.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/* Interceptor 역할을 해줄 클래스
* HandlerInterceptor 인터페이스를 상속 받아야 사용 가능
* 사용하고자 하는 메소드만 오버라이드 */
@Component
public class StopWatchInterceptor implements HandlerInterceptor {

    /* 생성자 주입 */
    public final MenuService menuService;

    /* @Autowired 생략
    * 생성자가 단일 일 시 생략 가능 */
    public StopWatchInterceptor(MenuService menuService) {
        this.menuService = menuService;
    }

    /* 전처리 메소드 */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        System.out.println("preHandler 호출함");

        /* 현재의 시간을 Long 타입으로 담는다. */
        long startTime = System.currentTimeMillis();

        /* 전처리 메소드가 실행 됐을 때 시간을 받아온다. */
        request.setAttribute("startTime", startTime);

        /* true를 반환하면 컨트롤러 메소드의 호출로 이어지고, false를 반환하면 호출하지 않는다. */
        return true;
    }

    /* 후처리 메소드 */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {

        System.out.println("postHandler 호출함");

        /* long startTime = System.currentTimeMillis(): 의 값을 파라미터로 받아온다. */
        long startTime = (Long) request.getAttribute("startTime");

        /* 후처리 메소드가 실행 됐을 때 시간을 받아온다. */
        long endTime = System.currentTimeMillis();

        modelAndView.addObject("interval", endTime - startTime);
    }

    /* view 렌더링 이후 동작하는 메소드 */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {

        System.out.println("afterCompletion 호출함");

        menuService.method();
    }
}
