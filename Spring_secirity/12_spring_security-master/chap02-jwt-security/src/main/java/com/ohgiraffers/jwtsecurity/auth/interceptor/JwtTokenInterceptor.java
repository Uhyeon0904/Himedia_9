package com.ohgiraffers.jwtsecurity.auth.interceptor;

import com.ohgiraffers.jwtsecurity.common.AuthConstants;
import com.ohgiraffers.jwtsecurity.common.utils.TokenUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

import java.rmi.RemoteException;

/* HandlerInterceptor: 요청 정보를 가로채가는 것 */
public class JwtTokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /* 토큰 유효성을 검증 */
        String header = request.getHeader(AuthConstants.TOKEN_TYPE);

        /* TokenUtils.splitHeader: 유효성 검사를 할 땐 베어리어를 분리해서 토큰에 대한 정보만 가져올 수 있게 한다.
        * (클래스.메소드명) 정적 메소드로 만들겠다. */
        String token = TokenUtils.splitHeader(header);

        if (token != null) {
            /* isValidToken: 유효한지 로직 작성 */
            if (TokenUtils.isValidToken(token)) {
                /* true를 반환해 줘야 인터셉터에서 다음 작업으로 넘어갈 수 있다. */
                return true;
            } else {
                throw new RemoteException("token이 만료 되었습니다.");
            }
        } else {
            throw new RemoteException("token 정보가 없습니다.");
        }
    }
}
