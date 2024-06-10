package com.ohgiraffers.jwtsecurity.auth.filter;

import com.ohgiraffers.jwtsecurity.auth.model.DetailsUser;
import com.ohgiraffers.jwtsecurity.common.AuthConstants;
import com.ohgiraffers.jwtsecurity.common.UserRole;
import com.ohgiraffers.jwtsecurity.common.utils.TokenUtils;
import com.ohgiraffers.jwtsecurity.user.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.SignatureException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* BasicAuthenticationFilter를 상속받아서 진행 */
public class JwtAuthorizationFilter extends BasicAuthenticationFilter{
    /* 부모한테 기본 생성자가 없기 때문에 생성자 구문이 필요 */
    public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        /* 필터체인에 걸리는 녀석, 어떤 요청이 들어왔을 때 인증 후 권한이 필요없는 경우 */
        List<String> roleLessList = Arrays.asList("/signup");
        if (roleLessList.contains((request.getRequestURI()))) {
            chain.doFilter(request, response);
            return;
        }

        /* Authorization header에서 정보를 가지고온다.
        * 문자열 사용 시 에러 확률이 있다.
        * AuthConstants 클래스에서 상수로 선언을 했다. */
        String header = request.getHeader(AuthConstants.AUTH_HEADER);

        try {
            /* equalsIgnoreCase: 타입을 무시하고 비교하겠다. */
            if (header != null && !header.equalsIgnoreCase("")) {
                /* 토큰이 유효하다면 토큰을 꺼내온다. */
                String token = TokenUtils.splitHeader(header);

                /* 토큰이 있다면 유효한지 */
                if (TokenUtils.isValidToken(token)) {
                    /* payload 부분만 Claims로 꺼내온다. */
                    Claims claims = TokenUtils.getClaimsFromToken(token);

                    DetailsUser authentication = new DetailsUser();
                    User user = new User();
                    /* claims에서 이름을 꺼내온다. 반환 타입이 Object 이기때문에 toString */
                    user.setUserName(claims.get("username").toString());
                    /* claims에서 권한을 꺼내온다. 반환 타입이 Object 이기때문에 toString */
                    user.setRole(UserRole.valueOf(claims.get("Role").toString()));
                    authentication.setUser(user);

                    AbstractAuthenticationToken authenticationToken
                            = UsernamePasswordAuthenticationToken
                            /* authenticated: 인증이 성공하고 나서 저장될 토큰을 생성 */
                            .authenticated(authentication, token, authentication.getAuthorities());

                    /* ?: ??? */
                    authenticationToken.setDetails(new WebAuthenticationDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                    chain.doFilter(request, response);
                } else {
                    throw new RuntimeException("토큰이 유효하지 않습니다.");
                }

            } else {
                throw new RuntimeException("토큰이 존재하지 않습니다.");
            }
        } catch (Exception e) {
            /* PrintWriter: 타입으로 내보내기 위해선 컨텐트 타입을 지정해야한다. */
            response.setContentType("application/json");
            PrintWriter printWriter = response.getWriter();
            /* jsonResponseWrapper: 큰 예외처리 발생 시 따로 구분하기 위해 메서드 생성 */
            JSONObject jsonObject = jsonResponseWrapper(e);
            printWriter.print(jsonObject);
            printWriter.flush();
            printWriter.close();
        }
    }

    /**
     * description. 토큰 관련 Exception 발생 시 예외 내용을 담은 객체 반환하는 메소드
     *
     * @param e : Exception
     * @return JSONObject
     */
    private JSONObject jsonResponseWrapper(Exception e) {
        String resultMsg = "";

        if (e instanceof ExpiredJwtException) {
            resultMsg = "Token Expired";
        } else if (e instanceof SignatureException) {
            resultMsg = "Token SignatureException";
        } else if (e instanceof JwtException) {
            resultMsg = "Token Parsing JwtException";
        } else {
            resultMsg = "othe Token Error";
        }
        HashMap<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("status", 401);
        jsonMap.put("message", resultMsg);
        jsonMap.put("reason", e.getMessage());

        return new JSONObject((jsonMap));
    }

}
